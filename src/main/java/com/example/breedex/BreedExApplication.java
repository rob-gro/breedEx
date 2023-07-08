package com.example.breedex;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import com.example.breedex.service.BreedService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BreedExApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreedExApplication.class, args);
    }
}

//
//    @Bean
//    CommandLineRunner runner(BreedService breedService) {
//        return args -> {
//
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Breed>> typeReference = new TypeReference<List<Breed>>() {
//            };
//            InputStream inputStream = BreedExApplication.class.getResourceAsStream("/json/dogs3.json");
////            Map<String, List<String>> node = new ObjectMapper().readValue("/json/dogs3.json", new TypeReference<Map<String, List<String>>>() {});
//            try {
//                List<Breed> breedsList = mapper.readValue(inputStream, typeReference);
//
///* 1
//
//- działa, ALE nie ma wartości z zagnieżdżonego klucza
//     {
//    "id": 2,
//    "breedName": "beagle",
//    "varietyName": [
//
//    ]
//  },
// */
//
//                for (Breed breed : breedsList) {
//                    List<Variety> varietyList = new ArrayList<>();
//                    Variety variety = new Variety();
//                    breed.getVarietyName() = ;
//                    varietyList.add(variety);
//                }
//                breedService.save(breedsList);
//                System.out.println(" ******* Breeds Saved! ******* ");
//
////                for(Breed breed : breedsList) {
////                    breed.getVarietyName();
////                    List<Variety> varietyList = new ArrayList<>();
////                    Variety variety = new Variety();
////                    variety.setVarietyName();
////                    varietyList.add(variety);
////                }
////                breedService.save();
////                System.out.println(" ******* Breeds Saved! ******* ");
//
//
//
///* 2
//
//- konflikt
//
//for (String varietyName - > Required type:Variety, Provided:String
//jak zmienię na "for (Variety varietyName :
//to wtedy "variety.setVarietiesName(varietyName);" -> Required type:String, Provided:Variety
//
//a jak wrap "variety.setVarietiesName(String.valueOf(varietyName));"
//to wtedy podczas kompilacji wywala:
//Cannot invoke "java.util.List.iterator()" because the return value of "com.example.breedex.model.Breed.getVarietyName()" is null
//*/
////
////                for (Breed breed : breedsList) {
////                    List<Variety> varieties = new ArrayList<>();
////                    for (Variety variety : breed.getVarietyName()) {
////                        variety = new Variety();
////                        variety.setVarietiesName(variety.getVarietiesName());
////                        varieties.add(variety);
////                    }
////                    breed.setVarietyName(varieties);
////                    breedService.save(breedsList);
////                }
//
//
// /*
// 3
//
// Cannot construct instance of `com.example.breedex.model.Variety` (although at least one Creator exists):
// no String-argument constructor/factory method to deserialize from String value ('boston')
// at [Source: (BufferedInputStream); line: 16, column: 21]
// (through reference chain: java.util.ArrayList[3]->com.example.breedex.model.Breed["varietyName"]->java.util.ArrayList[0])
//  */
////
////                for (Breed breed : breedsList) {
////                    List<Variety> varieties = new ArrayList<>();
////                    for (Variety variety : breed.getVarietyName()) {
////                        variety = new Variety();
////                        if (variety.getVarietyName() == null) {
////                            variety.getVarietyName();
////                        }
////                        variety.getVarietyName();
////                        varieties.add(variety);
////                    }
////                    breed.setVarietyName(varieties);
////                    breedService.save(breedsList);
////                }
//
//
///*
//4
//wywala błąd jak wyżej
// */
////                for (Breed breed : breedsList) {
////                    List<Variety> varieties = new ArrayList<>();
////                    if (breed.getVarietyName() != null) {
////                        for (Variety variety : breed.getVarietyName()) { //  Required type:String, Provided:Variety
////
////                            if (variety != null) {
////                                variety = new Variety();
////
////                            variety.setVarietyName(variety.getVarietyName());
////                            varieties.add(variety);
////                        }
////                    }
////                    breed.setVarietyName(varieties);
////                    breedService.save(breedsList);
////                }
///*
//
//5
//jak użyję IF to nie wykonuje pętli, bo dalej jest już NULL + a teraz zmienił się błąd
//        "no String-argument constructor/factory method to deserialize from String value .... "
//*/
//
////                for (Breed breed : breedsList) {
////                    List<Variety> varieties = new ArrayList<>();
////
////                    if (breed.getVarietyName() != null) {
////
////                        for (Variety varietyName : breed.getVarietyName()) {
////                            Variety variety = new Variety();
////                            variety.setVarietyName(String.valueOf(varietyName));
////                            varieties.add(variety);
////                        }
////                        breed.setVarietyName(varieties);
////                        breedService.save(breedsList);
////                    }
////                }
//
//
//            } catch (IOException e) {
//                System.out.println("****** Unable to save breeds: " + e.getMessage() + " *******");
//            }
//            System.out.println(" ******* Breeds Saved! ******* ");
//        };
//    }
//}
//
////    Function<ArrayNode, List<String>> extractValues = (node) ->
////            StreamSupport.stream(node.spliterator(), false)
////                    .map(JsonNode::asText)
////                    .collect(toImmutableList());
////
////    JsonNode node = new ObjectMapper().readTree("/json/dogs3.json");
////        if (node instanceof ObjectNode objectNode) {
////        for (Map.Entry<String, JsonNode> property : objectNode.properties()) {
////            if (property.getValue() instanceof ArrayNode arrayNode) {
////                System.out.println("key = " + property.getKey() + " values = " + extractValues.apply(arrayNode));
////            }
////        }
////    }
