package com.example.nbacademy.myapp.Activitys;

import android.util.ArrayMap;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class Suggestions {

    static List<Activitie> activities = new ArrayList();
    static List<Activitie> activitiesSelected = new ArrayList();
    static Map<Integer, List<Integer>> map;
    static int ids = 180;

    public Suggestions() {
        map = new ArrayMap<>();
        activities.add(new Activitie(1, "Istambul", "Mesquita Azul", "L", null, 0, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(2, "Istambul", "Museu Hagia Sophia e Igreja (Ayasofya)", "L", null, 8.55, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(3, "Istambul", "Grande Bazar", "L", null, 0, 4.4, 3, 0.0, 0.0));
        activities.add(new Activitie(4, "Istambul", "Palácio de Topkapi", "L", null, 8.55, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(5, "Istambul", "Tria Elegance Restaurant", "A", null, 15, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(6, "Istambul", "Cisterna da Basílica", "L", null, 4.27, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(7, "Istambul", "Palácio Dolmabahçe", "L", null, 8.55, 4.5, 2.5, 0.0, 0.0));
        activities.add(new Activitie(8, "Istambul", "Cruzeiro no Bósforo", "L", null, 3.2, 4.2, 2, 0.0, 0.0));
        activities.add(new Activitie(9, "Istambul", "Bazar das Especiarias", "L", null, 0, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(10, "Istambul", "Praça Taksim", "L", null, 0, 3.5, 0.5, 0.0, 0.0));
        activities.add(new Activitie(11, "Istambul", "Enjoyer Cafe & Restaurant", "A", null, 10, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(12, "Kuala Lumpur", "Little India", "L", null, 0, 3.7, 0.5, 0.0, 0.0));
        activities.add(new Activitie(13, "Kuala Lumpur", "Batu Caves", "L", null, 30, 4.8, 3, 0.0, 0.0));
        activities.add(new Activitie(14, "Kuala Lumpur", "Jonker Street Restaurant", "A", null, 20, 4.1, 1, 0.0, 0.0));
        activities.add(new Activitie(15, "Kuala Lumpur", "St Paul's Hill", "L", null, 0, 3.8, 1, 0.0, 0.0));
        activities.add(new Activitie(16, "Kuala Lumpur", "St Paul's church", "L", null, 0, 3.9, 1, 0.0, 0.0));
        activities.add(new Activitie(17, "Kuala Lumpur", "Cheng Hoon Teng", "L", null, 30, 4.8, 2.5, 0.0, 0.0));
        activities.add(new Activitie(18, "Kuala Lumpur", "Jonker Street Restaurant", "A", null, 20, 4.1, 1, 0.0, 0.0));
        activities.add(new Activitie(19, "Langkawi", "Kilim Karst Geoforest Park", "L", null, 105, 4.5, 4, 0.0, 0.0));
        activities.add(new Activitie(20, "Langkawi", "Pia's The Padi", "A", null, 15, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(21, "Langkawi", "Cenang Beach", "L", null, 0, 4, 4, 0.0, 0.0));
        activities.add(new Activitie(22, "Langkawi", "Haroo", "A", null, 12, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(23, "Langkawi", "Ponte Suspensa de Langkawi", "L", null, 12, 4.5, 4, 0.0, 0.0));
        activities.add(new Activitie(24, "Langkawi", "Telaga Tujuh Waterfalls", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(25, "Langkawi", "Tanjung Rhu Beach", "L", null, 0, 4.5, 6, 0.0, 0.0));
        activities.add(new Activitie(26, "Langkawi", "Art In Paradise", "L", null, 8, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(27, "Langkawi", "Wonderland Food Store", "A", null, 12, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(28, "Langkawi", "Langkawi Mangrove Forest and Eagle Watching Tour", "L", null, 60, 4.5, 7, 0.0, 0.0));
        activities.add(new Activitie(29, "Langkawi", "Yasmin Restaurant", "A", null, 8, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(30, "Tóquio", "Ueno Park", "L", null, 0, 4.4, 2, 0.0, 0.0));
        activities.add(new Activitie(31, "Tóquio", "Odaiba", "L", null, 0, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(32, "Tóquio", "Tokyo National Museum", "L", null, 4.5, 4.5, 3, 0.0, 0.0));
        activities.add(new Activitie(33, "Tóquio", "Han no Daidokoro", "A", null, 40, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(34, "Tóquio", "Harajuku", "L", null, 0, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(35, "Tóquio", "Tokyo Imperial Palace", "L", null, 0, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(36, "Tóquio", "Rainbow Bridge", "L", null, 0, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(37, "Tóquio", "Ise Sueyoshi", "A", null, 32, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(38, "Tóquio", "Meiji Jingu Shrine", "L", null, 0, 4.3, 3, 0.0, 0.0));
        activities.add(new Activitie(39, "Tóquio", "Ghibli Museum", "L", null, 7.5, 4.5, 3, 0.0, 0.0));
        activities.add(new Activitie(40, "Tóquio", "Tsukiji Fish Market", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(41, "Tóquio", "Glutenfree Cafe Little bird", "A", null, 20, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(42, "Tóquio", "Mount Takao", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(43, "Tóquio", "Takeshita Street", "L", null, 0, 3, 3, 0.0, 0.0));
        activities.add(new Activitie(44, "Tóquio", "Tokyo Sea Life Park", "L", null, 15, 5, 3, 0.0, 0.0));
        activities.add(new Activitie(45, "Tóquio", "Kaikaya", "A", null, 18, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(46, "Tóquio", "Torre de Tóquio", "L", null, 0, 4.4, 3, 0.0, 0.0));
        activities.add(new Activitie(47, "Tóquio", "Sensoji Temple", "L", null, 0, 5, 3, 0.0, 0.0));
        activities.add(new Activitie(48, "Tóquio", "Nabezo", "A", null, 25, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(49, "Honolulu", "Waikiki Beach", "L", null, 0, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(50, "Honolulu", "Pearl Harbor", "L", null, 25, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(51, "Honolulu", "Helena's Hawaiian Food", "A", null, 9, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(52, "Honolulu", "Polynesian Cultural Center", "L", null, 30, 2, 2, 0.0, 0.0));
        activities.add(new Activitie(53, "Honolulu", "Manoa Falls", "L", null, 0, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(54, "Honolulu", "National Memorial Cemetery Of the Pacific", "L", null, 8, 3, 3, 0.0, 0.0));
        activities.add(new Activitie(55, "Honolulu", "Side Street Inn", "A", null, 25, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(56, "Honolulu", "Honolulu Zoo", "L", null, 30, 5, 3, 0.0, 0.0));
        activities.add(new Activitie(57, "Honolulu", "Bishop Museum", "L", null, 20, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(58, "Honolulu", "Koko Crater Trail", "L", null, 0, 3, 3, 0.0, 0.0));
        activities.add(new Activitie(59, "Honolulu", "Ala Moana Center", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(60, "Honolulu", "Makapuu Lighthouse Trail", "L", null, 10, 2, 3, 0.0, 0.0));
        activities.add(new Activitie(61, "Honolulu", "Ala Moana Beach Park", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(62, "Honolulu", "Waikiki Aquarium", "L", null, 22, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(63, "Honolulu", "Ono Sea Food", "A", null, 30, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(64, "Honolulu", "Diamond Head", "L", null, 5, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(65, "Honolulu", "Hanauma Bay Nature Preserve", "L", null, 0, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(66, "Honolulu", "Iolani Palace", "L", null, 10, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(67, "Honolulu", "Steak Shak", "A", null, 18, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(68, "San Diego", "San Diego Zoo", "L", null, 25, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(69, "San Diego", "Balboa Park", "L", null, 0, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(70, "San Diego", "La Jolla Cove", "L", null, 10, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(71, "San Diego", "Petco Park", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(72, "San Diego", "USS Midway Museum", "L", null, 20, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(73, "San Diego", "Sunset Cliffs Natural Park", "L", null, 0, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(74, "San Diego", "Mount Soledad", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(75, "San Diego", "La Jolla Shores", "L", null, 0, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(76, "San Diego", "Torrey Pines Gliderport", "L", null, 10, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(77, "San Diego", "Sushi Ota", "A", null, 15, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(78, "San Diego", "SeaWorld San Diego", "L", null, 35, 5, 4, 0.0, 0.0));
        activities.add(new Activitie(79, "San Diego", "Maritime Museum of San Diego", "L", null, 10, 3, 1, 0.0, 0.0));
        activities.add(new Activitie(80, "San Diego", "Windansea Beach", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(81, "San Diego", "Botanical Building", "L", null, 10, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(82, "San Diego", "Cucina Urbana", "A", null, 20, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(83, "San Diego", "Coronado Island", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(84, "San Diego", "Birch Aquarium At Scripps", "L", null, 10, 3.5, 2, 0.0, 0.0));
        activities.add(new Activitie(85, "San Diego", "Fort Rosecrans National Cemetery", "L", null, 5, 3.5, 2, 0.0, 0.0));
        activities.add(new Activitie(86, "San Diego", "Old Town San Diego", "L", null, 15, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(87, "San Diego", "Pacific Beach", "L", null, 0, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(88, "San Diego", "Royal India", "A", null, 13, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(89, "Cusco / Machupicchu", "Mercado de Cuzco", "L", null, 0, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(90, "Cusco / Machupicchu", "Qorikancha (Templo do Sol)", "L", null, 3, 5, 0.75, 0.0, 0.0));
        activities.add(new Activitie(91, "Cusco / Machupicchu", "Catedral de Cuzco", "L", null, 0, 5, 0.75, 0.0, 0.0));
        activities.add(new Activitie(92, "Cusco / Machupicchu", "Q’engo", "L", null, 0, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(93, "Cusco / Machupicchu", "Vale Sagrado", "L", null, 0, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(94, "Cusco / Machupicchu", "Pisac", "L", null, 0, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(95, "Cusco / Machupicchu", "Ollantaytambo", "L", null, 0, 4, 1, 0.0, 0.0));
        activities.add(new Activitie(96, "Cusco / Machupicchu", "Águas Calientes", "L", null, 0, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(97, "Cusco / Machupicchu", "Machu Picchu", "L", null, 0, 5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(98, "Cusco / Machupicchu", "Cuzco", "L", null, 0, 5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(99, "Cusco / Machupicchu", "Tinkuy Buffet Restaurant at Sanctuary Lodge", "A", null, 12, 4.4, 0.0, 0.0, 0.0));
        activities.add(new Activitie(100, "Cusco / Machupicchu", "Chullpi Machupicchu Restaurante", "A", null, 15, 4.4, 0.0, 0.0, 0.0));
        activities.add(new Activitie(101, "Cusco / Machupicchu", "AYASQA - Comida tradicional", "A", null, 20, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(102, "Cusco / Machupicchu", "Restaurante Apu Salkantay", "A", null, 15, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(103, "Cusco / Machupicchu", "Tree House", "A", null, 11, 5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(104, "Cusco / Machupicchu", "Incontri del Pueblo Viejo", "A", null, 40, 5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(105, "Cusco / Machupicchu", "Full House Peruvian Cuisine", "A", null, 20, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(106, "Cusco / Machupicchu", "Palate bistro machupichu", "A", null, 13, 4, 0.0, 0.0, 0.0));
        activities.add(new Activitie(107, "Buenos Aires", "Plaza de La Republica);", "L", null, 0, 4, 1, 0.0, 0.0));
        activities.add(new Activitie(108, "Buenos Aires", "Teatro Colon (na mesma avenida 9 de Julio));", "L", null, 5, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(109, "Buenos Aires", "Galerias Pacífico (seguindo pela Avenida Córdoba));", "L", null, 0, 4.8, 1, 0.0, 0.0));
        activities.add(new Activitie(110, "Buenos Aires", "Calle Florida (saindo da Galerias Pacífico pegue a rua Florida quase no início));", "L", null, 0, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(111, "Buenos Aires", "Plaza de Maio e seus Prédios: Catedral, Casa Rosada, Palácio Municipal de Buenos Aires e Banco de La Nación);", "L", null, 0, 3, 1, 0.0, 0.0));
        activities.add(new Activitie(112, "Buenos Aires", "Parque Colón (fica nas costas da Casa Rosada));", "L", null, 0, 3, 1, 0.0, 0.0));
        activities.add(new Activitie(113, "Buenos Aires", "Café Tortoni (seguindo pela Avendia de Mayo));", "L", null, 0, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(114, "Buenos Aires", "Cemitério da Recoleta);", "L", null, 0, 5, 0.5, 0.0, 0.0));
        activities.add(new Activitie(115, "Buenos Aires", "Buenos Aires Design);", "L", null, 10, 4, 1, 0.0, 0.0));
        activities.add(new Activitie(116, "Buenos Aires", "Floralis Generica.", "L", null, 5, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(117, "Buenos Aires", "Museu Nacional de Belas Artes);", "L", null, 5, 5, 1.5, 0.0, 0.0));
        activities.add(new Activitie(118, "Buenos Aires", "Ruas e lojas da Recoleta.", "L", null, 0, 5, 2.5, 0.0, 0.0));
        activities.add(new Activitie(119, "Buenos Aires", "Jardim Zoológico,", "L", null, 30, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(120, "Buenos Aires", "Jardim Japonês,", "L", null, 5, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(121, "Buenos Aires", "Planetário Galileo Galilei", "L", null, 10, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(122, "Buenos Aires", "Chila", "A", null, 15, 4.3, 0.0, 0.0, 0.0));
        activities.add(new Activitie(123, "Buenos Aires", "El Desnível", "A", null, 25, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(124, "Buenos Aires", "El San Juanino", "A", null, 15, 3.8, 0.0, 0.0, 0.0));
        activities.add(new Activitie(125, "Buenos Aires", "Il Matterello", "A", null, 45, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(126, "Buenos Aires", "La Bourgogne", "A", null, 18, 4.4, 0.0, 0.0, 0.0));
        activities.add(new Activitie(127, "Buenos Aires", "La Mansión", "A", null, 18, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(128, "Buenos Aires", "Le Sud", "A", null, 26, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(129, "Buenos Aires", "Olsen", "A", null, 25, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(130, "Buenos Aires", "Oviedo", "A", null, 16, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(131, "Iguaçu", "Hidroeléctrica de Itaipu (circuito especial)", "L", null, 50, 4.3, 2, 0.0, 0.0));
        activities.add(new Activitie(132, "Iguaçu", "Salto de Paraquedas sob as barragens", "L", null, 15, 4.6, 1, 0.0, 0.0));
        activities.add(new Activitie(133, "Iguaçu", "Iluminação da Barragem (noturno)", "L", null, 200, 3.8, 1, 0.0, 0.0));
        activities.add(new Activitie(134, "Iguaçu", "Vista Panorâmica", "L", null, 10, 4.5, 0.5, 0.0, 0.0));
        activities.add(new Activitie(135, "Iguaçu", "Ponte da Amizade", "L", null, 0, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(136, "Iguaçu", "Cataratas do Iguaçu", "L", null, 0, 4.6, 3.5, 0.0, 0.0));
        activities.add(new Activitie(137, "Iguaçu", "Parque das Aves Backstage Experience", "L", null, 10, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(138, "Iguaçu", "Museu de Cera", "L", null, 7.5, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(139, "Iguaçu", "Parque dos dinossauros", "L", null, 6, 5, 1, 0.0, 0.0));
        activities.add(new Activitie(140, "Iguaçu", "Ice Bar Iguazu", "L", null, 5, 4.5, 1, 0.0, 0.0));
        activities.add(new Activitie(141, "Iguaçu", "Templo Budista", "L", null, 0, 4.7, 1, 0.0, 0.0));
        activities.add(new Activitie(142, "Iguaçu", "Restaurante Iguaçu", "A", null, 15, 4.3, 0.0, 0.0, 0.0));
        activities.add(new Activitie(143, "Iguaçu", "Restaurante Barracão", "A", null, 28, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(144, "Iguaçu", "Restaurante Porto Canoas", "A", null, 45, 3.8, 0.0, 0.0, 0.0));
        activities.add(new Activitie(145, "Iguaçu", "Pizzaria Martignoni", "A", null, 20, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(146, "Iguaçu", "Madero Steak House", "A", null, 25, 4.4, 0.0, 0.0, 0.0));
        activities.add(new Activitie(147, "Iguaçu", "Noite Italiana Bella Italia - Foz do Iguaçu", "A", null, 16, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(148, "Iguaçu", "Churrascaria do Gaúcho", "A", null, 10, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(149, "Iguaçu", "La Mafia Trattoria", "A", null, 13, 4.5, 0.0, 0.0, 0.0));
        activities.add(new Activitie(150, "Iguaçu", "Vô Luiz Pizzeria & Cucina", "A", null, 26, 4.2, 0.0, 0.0, 0.0));
        activities.add(new Activitie(151, "Iguaçu", "Churrascaria Bufalo Branco", "A", null, 10, 4.6, 0.0, 0.0, 0.0));
        activities.add(new Activitie(152, "Iguaçu", "BENDITO Bar e Restaurante", "A", null, 29, 4.4, 0.0, 0.0, 0.0));
        activities.add(new Activitie(153, "Iguaçu", "Trapiche Restaurante", "A", null, 35, 3.9, 0.0, 0.0, 0.0));
        activities.add(new Activitie(154, "Iguaçu", "La Strega", "A", null, 12, 4.7, 0.0, 0.0, 0.0));
        activities.add(new Activitie(155, "Iguaçu", "Empório com Arte", "A", null, 15, 4.7, 0.0, 0.0, 0.0));
        activities.add(new Activitie(156, "Rio de Janeiro", "Cristo Redentor", "L", null, 11.5, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(157, "Rio de Janeiro", "Pao de Açucar", "L", null, 11, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(158, "Rio de Janeiro", "Zaza Bistro Tropical", "A", null, 35, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(159, "Rio de Janeiro", "Sugarloaf", "L", null, 25, 4, 3, 0.0, 0.0));
        activities.add(new Activitie(160, "Rio de Janeiro", "Copacabana Beach", "L", null, 0, 4.5, 2, 0.0, 0.0));
        activities.add(new Activitie(161, "Rio de Janeiro", "Jardim Botânico", "L", null, 10, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(162, "Rio de Janeiro", "La Bicyclette", "A", null, 20, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(163, "Rio de Janeiro", "Ipanema Beach", "L", null, 0, 5, 2, 0.0, 0.0));
        activities.add(new Activitie(164, "Rio de Janeiro", "Theatro Municipal do Rio de Janeiro", "L", null, 2.5, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(165, "Rio de Janeiro", "Bonde de Santa Teresa", "L", null, 20, 3, 2, 0.0, 0.0));
        activities.add(new Activitie(166, "Rio de Janeiro", "Maracana Football Stadium", "L", null, 9, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(167, "Rio de Janeiro", "Confeitaria Colombo", "A", null, 10, 4, 2, 0.0, 0.0));
        activities.add(new Activitie(168, "Rio de Janeiro", "Museu Nacional de Belas Artes", "L", null, 2, 4.5, 1.5, 0.0, 0.0));
        activities.add(new Activitie(169, "Rio de Janeiro", "Museu Histórico do Exercito e Forte de Copacabana", "L", null, 1.5, 3.5, 1.5, 0.0, 0.0));
        activities.add(new Activitie(170, "Rio de Janeiro", "Gabbiano Ristorante", "A", null, 10, 4, 2, 0.0, 0.0));
    }

    public static Activitie getAct(int id) {
        Activitie toReturn = null;
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getId() == id) {
                toReturn = activities.get(i);
                break;
            }
        }
        return toReturn;
    }


    public static void add(String name, String cidade, String tipo, double preco, double inici, double fim, double ranking) {
        Log.d("add", name);

        Log.d("add", cidade);
        Log.d("add", tipo);
        Log.d("add", preco + "");
        Log.d("add", inici + "");
        Log.d("add", fim + "");
        Log.d("add", ranking + "");

        Log.d("add", ids + "");


        activities.add(new Activitie(ids, cidade, name, tipo, null, preco, ranking, 0, inici, fim));
        ids++;

        Log.d("add", ids + "");
    }

    public static int getlast() {
        return ids - 1;
    }

    public static List<Activitie> getActivities(int i) {

        Log.d("ttt", i + " detro " + activities.size());

        String city = Citys.locais.get(i).getOrigem();
        List<Activitie> t = new ArrayList();
        for (int y = 0; y < activities.size(); y++) {

            Log.d("FC", activities.get(y).getCity() + "-" + city + "  teste");

            if (activities.get(y).getCity().equals(city)) {
                Log.d("teste", y + "entradas");
                t.add(activities.get(y));
                activitiesSelected.add(activities.get(y));
            }


        }
        Log.d("teste", t.size() + "taman");
        return t;
    }

}
