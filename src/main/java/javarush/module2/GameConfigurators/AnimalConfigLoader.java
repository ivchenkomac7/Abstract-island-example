package javarush.module2.GameConfigurators;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// Завантажувач конфігурації тварин
public class AnimalConfigLoader {
    private static final String PREDATORS_PATH = "src/main/resources/config/entities/animals/predator";
    private static final String HERBIVORES_PATH = "src/main/resources/config/entities/animals/herbivore";

    public static Map<String, AnimalAttributes> loadPredators() {
        return loadAnimalsFromFolder(PREDATORS_PATH);
    }

    public static Map<String, AnimalAttributes> loadHerbivores() {
        return loadAnimalsFromFolder(HERBIVORES_PATH);
    }

    private static Map<String, AnimalAttributes> loadAnimalsFromFolder(String folderPath) {
        Map<String, AnimalAttributes> animals = new HashMap<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".xml"));

        if (files != null) {
            for (File file : files) {
                String animalName = file.getName().replace(".xml", "");
                AnimalAttributes attributes = loadAnimalConfig(file.getPath());
                if (attributes != null) {
                    animals.put(animalName, attributes);
                }
            }
        }
        return animals;
    }

    private static AnimalAttributes loadAnimalConfig(String filePath) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            double weight = Double.parseDouble(root.getElementsByTagName("weight").item(0).getTextContent());
            int maxCountPerCell = Integer.parseInt(root.getElementsByTagName("maxCountPerCell").item(0).getTextContent());
            int speed = Integer.parseInt(root.getElementsByTagName("speed").item(0).getTextContent());
            double foodNeeded = Double.parseDouble(root.getElementsByTagName("foodNeeded").item(0).getTextContent());

            return new AnimalAttributes(weight, maxCountPerCell, speed, foodNeeded);
        } catch (Exception e) {
            System.err.println("Помилка завантаження конфігурації: " + filePath);
            e.printStackTrace();
            return null;
        }
    }
}