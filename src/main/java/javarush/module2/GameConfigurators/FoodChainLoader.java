package javarush.module2.GameConfigurators;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// Завантажувач харчового ланцюга з XML
public class FoodChainLoader {
    private static final String FOOD_CHAIN_PATH = "src/main/resources/config/entities/animals/food_chain/food_chain.xml";

    public static Map<String, Map<String, Double>> loadFoodChain() {
        Map<String, Map<String, Double>> foodChain = new HashMap<>();

        try {
            if (!Files.exists(Paths.get(FOOD_CHAIN_PATH))) {
                System.err.println("Файл харчового ланцюга не знайдено: " + FOOD_CHAIN_PATH);
                return foodChain;
            }

            File file = new File(FOOD_CHAIN_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList animals = doc.getElementsByTagName("Animal");
            for (int i = 0; i < animals.getLength(); i++) {
                Element animal = (Element) animals.item(i);
                String predator = animal.getAttribute("name");
                Map<String, Double> preyMap = new HashMap<>();

                NodeList preys = animal.getElementsByTagName("Prey");
                for (int j = 0; j < preys.getLength(); j++) {
                    Element prey = (Element) preys.item(j);
                    String preyName = prey.getAttribute("name");
                    double probability = Double.parseDouble(prey.getAttribute("probability"));
                    preyMap.put(preyName, probability);
                }
                foodChain.put(predator, preyMap);
            }
        } catch (Exception e) {
            System.err.println("Помилка завантаження харчового ланцюга");
            e.printStackTrace();
        }
        return foodChain;
    }
}
