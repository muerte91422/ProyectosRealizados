package com.mycompany.creadorrecetas;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class GeneradorRecetas {

    public static void main(String[] args) {
        List<Recetas> listaReceta = new ArrayList<>();

        // Receta 1: Espaguetis a la Carbonara
        ArrayList<String> ing1 = new ArrayList<>();
        ing1.add("200g de espaguetis");
        ing1.add("100g de panceta");
        ing1.add("2 huevos grandes");
        ing1.add("50g de queso Pecorino");
        ing1.add("50g de queso Parmesano");
        ing1.add("Pimienta negra");
        ing1.add("Sal");
        ArrayList<String> pasos1 = new ArrayList<>();
        pasos1.add("Lleva una olla grande con agua salada a ebullicion. Anade los espaguetis y cocina segun las instrucciones del paquete hasta que esten al dente, luego escurre, reservando 1 taza del agua de coccion.");
        pasos1.add("En una sarten, cocina la panceta a fuego medio hasta que este crujiente, aproximadamente 5-7 minutos. Retira del fuego.");
        pasos1.add("En un tazon, bate los huevos, el queso Pecorino rallado, el queso Parmesano rallado y una cantidad generosa de pimienta negra hasta que esten bien combinados.");
        pasos1.add("Anade los espaguetis escurridos y calientes a la sarten con la panceta. Vierte la mezcla de huevo sobre la pasta y mezcla rapidamente para cubrir, anadiendo agua de coccion reservada segun sea necesario para crear una salsa cremosa. Sirve inmediatamente.");
        listaReceta.add(new Recetas("Espaguetis a la Carbonara", ing1, pasos1, 20));

        // Receta 2: Tostada de Aguacate
        ArrayList<String> ing2 = new ArrayList<>();
        ing2.add("2 rebanadas de pan");
        ing2.add("1 aguacate maduro");
        ing2.add("1 limon");
        ing2.add("Sal");
        ing2.add("Pimienta");
        ing2.add("Opcional: huevo escalfado");
        ArrayList<String> pasos2 = new ArrayList<>();
        pasos2.add("Tuesta las rebanadas de pan en una tostadora o sarten hasta que esten doradas.");
        pasos2.add("Tritura el aguacate en un tazon con un tenedor, anadiendo un chorrito de jugo de limon, sal y pimienta al gusto.");
        pasos2.add("Unta el aguacate triturado uniformemente sobre el pan tostado.");
        pasos2.add("Coloca un huevo escalfado encima si lo deseas y sirve inmediatamente para el desayuno.");
        listaReceta.add(new Recetas("Tostada de Aguacate", ing2, pasos2, 10));

        // Receta 3: Salteado de Pollo
        ArrayList<String> ing3 = new ArrayList<>();
        ing3.add("300g de pechuga de pollo");
        ing3.add("2 tazas de verduras mixtas");
        ing3.add("2 cucharadas de salsa de soja");
        ing3.add("1 cucharada de aceite de sesamo");
        ing3.add("2 dientes de ajo");
        ing3.add("2 cm de jengibre");
        ArrayList<String> pasos3 = new ArrayList<>();
        pasos3.add("Corta la pechuga de pollo en tiras finas y pica el ajo y el jengibre.");
        pasos3.add("Calienta el aceite de sesamo en un wok a fuego alto, anade el ajo y el jengibre, y saltea durante 30 segundos hasta que esten fragantes.");
        pasos3.add("Anade las tiras de pollo y saltea hasta que esten doradas y cocidas, aproximadamente 5 minutos.");
        pasos3.add("Anade las verduras mixtas y la salsa de soja, saltea durante 3-4 minutos mas hasta que las verduras esten tiernas pero crujientes. Sirve caliente con arroz.");
        listaReceta.add(new Recetas("Salteado de Pollo", ing3, pasos3, 15));

        // Receta 4: Ensalada Griega
        ArrayList<String> ing4 = new ArrayList<>();
        ing4.add("2 pepinos");
        ing4.add("4 tomates");
        ing4.add("1 cebolla roja");
        ing4.add("200g de queso feta");
        ing4.add("100g de aceitunas");
        ing4.add("Aceite de oliva");
        ing4.add("Oregano");
        ArrayList<String> pasos4 = new ArrayList<>();
        pasos4.add("Corta los pepinos, tomates y la cebolla roja en trozos pequenos.");
        pasos4.add("En un tazon grande, combina las verduras cortadas con las aceitunas y el queso feta desmenuzado.");
        pasos4.add("Rocia con aceite de oliva, espolvorea oregano, sal y pimienta al gusto.");
        pasos4.add("Mezcla suavemente y sirve como acompanamiento fresco.");
        listaReceta.add(new Recetas("Ensalada Griega", ing4, pasos4, 10));

        // Receta 5: Panqueques de Platano
        ArrayList<String> ing5 = new ArrayList<>();
        ing5.add("2 platanos maduros");
        ing5.add("2 huevos");
        ing5.add("1/2 taza de avena");
        ing5.add("1 cucharadita de polvo de hornear");
        ing5.add("Canela");
        ArrayList<String> pasos5 = new ArrayList<>();
        pasos5.add("Tritura los platanos en un tazon hasta que esten suaves.");
        pasos5.add("Bate los huevos, la avena, el polvo de hornear y una pizca de canela.");
        pasos5.add("Calienta una sarten antiadherente a fuego medio y vierte la masa para formar panqueques.");
        pasos5.add("Cocina durante 2-3 minutos por cada lado hasta que esten dorados. Sirve con miel o frutas.");
        listaReceta.add(new Recetas("Panqueques de Platano", ing5, pasos5, 15));

        // Receta 6: Tacos de Carne
        ArrayList<String> ing6 = new ArrayList<>();
        ing6.add("500g de carne molida");
        ing6.add("8 tortillas para tacos");
        ing6.add("1 cebolla");
        ing6.add("2 tomates");
        ing6.add("Lechuga");
        ing6.add("Queso");
        ing6.add("Sazonador para tacos");
        ArrayList<String> pasos6 = new ArrayList<>();
        pasos6.add("Pica la cebolla y los tomates finamente.");
        pasos6.add("En una sarten, cocina la carne molida con la cebolla picada y el sazonador para tacos hasta que este dorada, aproximadamente 10 minutos.");
        pasos6.add("Calienta las tortillas en el horno.");
        pasos6.add("Arma los tacos con carne, tomates, lechuga y queso rallado. Sirve inmediatamente.");
        listaReceta.add(new Recetas("Tacos de Carne", ing6, pasos6, 20));

        // Receta 7: Sopa de Verduras
        ArrayList<String> ing7 = new ArrayList<>();
        ing7.add("2 zanahorias");
        ing7.add("2 tallos de apio");
        ing7.add("1 cebolla");
        ing7.add("4 tazas de caldo de verduras");
        ing7.add("2 papas");
        ing7.add("Hierbas");
        ArrayList<String> pasos7 = new ArrayList<>();
        pasos7.add("Corta todas las verduras en trozos pequenos.");
        pasos7.add("En una olla, sofri la cebolla, las zanahorias y el apio en aceite hasta que se ablanden.");
        pasos7.add("Anade las papas, el caldo y las hierbas; lleva a ebullicion y luego cocina a fuego lento durante 20 minutos.");
        pasos7.add("Licua si deseas una textura mas suave y sirve caliente.");
        listaReceta.add(new Recetas("Sopa de Verduras", ing7, pasos7, 30));

        // Receta 8: Galletas de Chispas de Chocolate
        ArrayList<String> ing8 = new ArrayList<>();
        ing8.add("200g de harina");
        ing8.add("150g de mantequilla");
        ing8.add("100g de azucar");
        ing8.add("100g de azucar morena");
        ing8.add("1 huevo");
        ing8.add("200g de chispas de chocolate");
        ing8.add("1 cucharadita de vainilla");
        ArrayList<String> pasos8 = new ArrayList<>();
        pasos8.add("Precalienta el horno a 180C.");
        pasos8.add("Bate la mantequilla, el azucar y el azucar morena hasta que esten esponjosos, luego anade el huevo y la vainilla.");
        pasos8.add("Mezcla la harina y las chispas de chocolate para formar una masa.");
        pasos8.add("Coloca porciones en una bandeja para hornear y hornea durante 10-12 minutos hasta que esten doradas.");
        listaReceta.add(new Recetas("Galletas de Chispas de Chocolate", ing8, pasos8, 25));

        // Receta 9: Ensalada Cesar
        ArrayList<String> ing9 = new ArrayList<>();
        ing9.add("1 lechuga romana");
        ing9.add("100g de crutones");
        ing9.add("50g de queso Parmesano");
        ing9.add("Aderezo Cesar");
        ing9.add("Opcional: pollo");
        ArrayList<String> pasos9 = new ArrayList<>();
        pasos9.add("Lava y corta la lechuga romana en trozos pequenos.");
        pasos9.add("En un tazon, mezcla la lechuga con crutones y queso Parmesano rallado.");
        pasos9.add("Rocia con aderezo Cesar y mezcla bien.");
        pasos9.add("Anade pollo asado si lo deseas y sirve fresco.");
        listaReceta.add(new Recetas("Ensalada Cesar", ing9, pasos9, 10));

        // Receta 10: Tazon de Smoothie
        ArrayList<String> ing10 = new ArrayList<>();
        ing10.add("2 platanos");
        ing10.add("1 taza de frutos rojos");
        ing10.add("1/2 taza de yogur");
        ing10.add("Toppings: granola, nueces");
        ArrayList<String> pasos10 = new ArrayList<>();
        pasos10.add("Licua platanos congelados, frutos rojos y yogur hasta que este suave.");
        pasos10.add("Vierte en un tazon.");
        pasos10.add("Cubre con granola, nueces y frutas frescas.");
        pasos10.add("Sirve inmediatamente para un desayuno saludable.");
        listaReceta.add(new Recetas("Tazon de Smoothie", ing10, pasos10, 5));

        // Receta 11: Pizza Margherita
        ArrayList<String> ing11 = new ArrayList<>();
        ing11.add("Masa para pizza");
        ing11.add("Salsa de tomate");
        ing11.add("Queso mozzarella");
        ing11.add("Albahaca fresca");
        ing11.add("Aceite de oliva");
        ArrayList<String> pasos11 = new ArrayList<>();
        pasos11.add("Precalienta el horno a 220C.");
        pasos11.add("Estira la masa para pizza en una superficie enharinada.");
        pasos11.add("Esparce salsa de tomate, anade mozzarella en rodajas y rocia aceite de oliva.");
        pasos11.add("Hornea durante 12-15 minutos, luego cubre con albahaca fresca.");
        listaReceta.add(new Recetas("Pizza Margherita", ing11, pasos11, 20));

        // Receta 12: Arroz Frito
        ArrayList<String> ing12 = new ArrayList<>();
        ing12.add("2 tazas de arroz cocido");
        ing12.add("1 taza de verduras mixtas");
        ing12.add("2 huevos");
        ing12.add("Salsa de soja");
        ing12.add("Cebollas verdes");
        ArrayList<String> pasos12 = new ArrayList<>();
        pasos12.add("Calienta aceite en un wok, revuelve los huevos y reservalos.");
        pasos12.add("Saltea las verduras hasta que esten tiernas.");
        pasos12.add("Anade el arroz, la salsa de soja y los huevos; mezcla bien.");
        pasos12.add("Decora con cebollas verdes picadas y sirve.");
        listaReceta.add(new Recetas("Arroz Frito", ing12, pasos12, 15));

        // Receta 13: Sandwich Caprese
        ArrayList<String> ing13 = new ArrayList<>();
        ing13.add("2 rebanadas de pan");
        ing13.add("Queso mozzarella");
        ing13.add("Tomate");
        ing13.add("Albahaca");
        ing13.add("Glaseado balsamico");
        ArrayList<String> pasos13 = new ArrayList<>();
        pasos13.add("Corta el mozzarella y el tomate en rodajas.");
        pasos13.add("Coloca en el pan con hojas de albahaca.");
        pasos13.add("Rocia con glaseado balsamico.");
        pasos13.add("Asa o sirve frio como sandwich.");
        listaReceta.add(new Recetas("Sandwich Caprese", ing13, pasos13, 10));

        // Receta 14: Pollo al Limon
        ArrayList<String> ing14 = new ArrayList<>();
        ing14.add("4 pechugas de pollo");
        ing14.add("2 limones");
        ing14.add("Ajo");
        ing14.add("Hierbas");
        ing14.add("Aceite de oliva");
        ArrayList<String> pasos14 = new ArrayList<>();
        pasos14.add("Marina el pollo en jugo de limon, ajo, hierbas y aceite durante 30 minutos.");
        pasos14.add("Precalienta el horno a 200C.");
        pasos14.add("Hornea el pollo durante 25-30 minutos hasta que este cocido.");
        pasos14.add("Sirve con rodajas de limon.");
        listaReceta.add(new Recetas("Pollo al Limon", ing14, pasos14, 40));

        // Receta 15: Parfait de Frutos Rojos
        ArrayList<String> ing15 = new ArrayList<>();
        ing15.add("Yogur");
        ing15.add("Frutos rojos");
        ing15.add("Granola");
        ing15.add("Miel");
        ArrayList<String> pasos15 = new ArrayList<>();
        pasos15.add("Coloca una capa de yogur en el fondo de un vaso.");
        pasos15.add("Anade una capa de frutos rojos.");
        pasos15.add("Cubre con granola y rocia miel.");
        pasos15.add("Repite las capas y sirve frio.");
        listaReceta.add(new Recetas("Parfait de Frutos Rojos", ing15, pasos15, 5));

        // Receta 16: Ensalada de Atun
        ArrayList<String> ing16 = new ArrayList<>();
        ing16.add("1 lata de atun");
        ing16.add("Mayonesa");
        ing16.add("Apio");
        ing16.add("Cebolla");
        ing16.add("Lechuga");
        ArrayList<String> pasos16 = new ArrayList<>();
        pasos16.add("Escurre el atun y mezclalo con apio picado, cebolla y mayonesa.");
        pasos16.add("Sazona con sal y pimienta.");
        pasos16.add("Sirve sobre hojas de lechuga o en un sandwich.");
        pasos16.add("Enfria antes de servir si lo deseas.");
        listaReceta.add(new Recetas("Ensalada de Atun", ing16, pasos16, 10));

        // Receta 17: Hamburguesa Vegetariana
        ArrayList<String> ing17 = new ArrayList<>();
        ing17.add("Frijoles negros");
        ing17.add("Avena");
        ing17.add("Cebolla");
        ing17.add("Especias");
        ing17.add("Panes para hamburguesa");
        ArrayList<String> pasos17 = new ArrayList<>();
        pasos17.add("Tritura los frijoles negros y mezclalos con avena, cebolla picada y especias.");
        pasos17.add("Forma hamburguesas.");
        pasos17.add("Cocina en una sarten durante 4-5 minutos por cada lado.");
        pasos17.add("Sirve en panes con acompanamientos.");
        listaReceta.add(new Recetas("Hamburguesa Vegetariana", ing17, pasos17, 20));

        // Receta 18: Pay de Manzana
        ArrayList<String> ing18 = new ArrayList<>();
        ing18.add("Masa para pay");
        ing18.add("6 manzanas");
        ing18.add("Azucar");
        ing18.add("Canela");
        ing18.add("Mantequilla");
        ArrayList<String> pasos18 = new ArrayList<>();
        pasos18.add("Precalienta el horno a 190C.");
        pasos18.add("Pela y corta las manzanas, mezclalas con azucar y canela.");
        pasos18.add("Coloca en la masa para pay, anade trozos de mantequilla, cubre con otra capa de masa.");
        pasos18.add("Hornea durante 45-50 minutos hasta que este dorado.");
        listaReceta.add(new Recetas("Pay de Manzana", ing18, pasos18, 60));

        // Receta 19: Ensalada de Quinoa
        ArrayList<String> ing19 = new ArrayList<>();
        ing19.add("1 taza de quinoa");
        ing19.add("Pepino");
        ing19.add("Tomate");
        ing19.add("Queso feta");
        ing19.add("Aderezo de limon");
        ArrayList<String> pasos19 = new ArrayList<>();
        pasos19.add("Cocina la quinoa segun el paquete, dejala enfriar.");
        pasos19.add("Corta las verduras y mezclalas con la quinoa y el queso feta.");
        pasos19.add("Rocia con aderezo de limon.");
        pasos19.add("Mezcla y sirve frio.");
        listaReceta.add(new Recetas("Ensalada de Quinoa", ing19, pasos19, 20));

        // Receta 20: Tostadas Francesas
        ArrayList<String> ing20 = new ArrayList<>();
        ing20.add("4 rebanadas de pan");
        ing20.add("2 huevos");
        ing20.add("Leche");
        ing20.add("Canela");
        ing20.add("Vainilla");
        ArrayList<String> pasos20 = new ArrayList<>();
        pasos20.add("Bate los huevos, la leche, la canela y la vainilla en un tazon.");
        pasos20.add("Sumerge las rebanadas de pan en la mezcla.");
        pasos20.add("Cocina en una sarten hasta que esten doradas por ambos lados.");
        pasos20.add("Sirve con jarabe o frutas.");
        listaReceta.add(new Recetas("Tostadas Francesas", ing20, pasos20, 15));

        // Receta 21: Gambas al Ajillo
        ArrayList<String> ing21 = new ArrayList<>();
        ing21.add("300g de gambas");
        ing21.add("Pasta");
        ing21.add("Ajo");
        ing21.add("Limon");
        ing21.add("Mantequilla");
        ArrayList<String> pasos21 = new ArrayList<>();
        pasos21.add("Cocina la pasta al dente.");
        pasos21.add("Sofri el ajo en mantequilla, anade las gambas hasta que esten rosadas.");
        pasos21.add("Anade jugo de limon y mezcla con la pasta.");
        pasos21.add("Sirve con perejil.");
        listaReceta.add(new Recetas("Gambas al Ajillo", ing21, pasos21, 20));

        // Receta 22: Avena
        ArrayList<String> ing22 = new ArrayList<>();
        ing22.add("1 taza de avena");
        ing22.add("2 tazas de leche");
        ing22.add("Frutas");
        ing22.add("Nueces");
        ing22.add("Miel");
        ArrayList<String> pasos22 = new ArrayList<>();
        pasos22.add("Lleva la leche a ebullicion, anade la avena.");
        pasos22.add("Cocina a fuego lento durante 5 minutos, revolviendo ocasionalmente.");
        pasos22.add("Cubre con frutas, nueces y miel.");
        pasos22.add("Sirve caliente.");
        listaReceta.add(new Recetas("Avena", ing22, pasos22, 10));

        // Receta 23: Estofado de Carne
        ArrayList<String> ing23 = new ArrayList<>();
        ing23.add("500g de carne");
        ing23.add("Zanahorias");
        ing23.add("Papas");
        ing23.add("Cebolla");
        ing23.add("Caldo");
        ArrayList<String> pasos23 = new ArrayList<>();
        pasos23.add("Dora la carne en una olla.");
        pasos23.add("Anade las verduras picadas y el caldo.");
        pasos23.add("Cocina a fuego lento durante 1-2 horas hasta que este tierno.");
        pasos23.add("Sazona y sirve caliente.");
        listaReceta.add(new Recetas("Estofado de Carne", ing23, pasos23, 120));

        // Receta 24: Pasta al Pesto
        ArrayList<String> ing24 = new ArrayList<>();
        ing24.add("Pasta");
        ing24.add("Salsa pesto");
        ing24.add("Pinones");
        ing24.add("Queso Parmesano");
        ArrayList<String> pasos24 = new ArrayList<>();
        pasos24.add("Cocina la pasta al dente.");
        pasos24.add("Mezcla con salsa pesto.");
        pasos24.add("Cubre con pinones y Parmesano.");
        pasos24.add("Sirve inmediatamente.");
        listaReceta.add(new Recetas("Pasta al Pesto", ing24, pasos24, 15));

        // Receta 25: Ensalada de Frutas
        ArrayList<String> ing25 = new ArrayList<>();
        ing25.add("Frutas variadas");
        ing25.add("Miel");
        ing25.add("Lima");
        ArrayList<String> pasos25 = new ArrayList<>();
        pasos25.add("Corta las frutas en trozos.");
        pasos25.add("Mezcla en un tazon.");
        pasos25.add("Rocia miel y jugo de lima.");
        pasos25.add("Mezcla y enfria antes de servir.");
        listaReceta.add(new Recetas("Ensalada de Frutas", ing25, pasos25, 10));

        // Receta 26: Sandwich de Queso a la Parrilla
        ArrayList<String> ing26 = new ArrayList<>();
        ing26.add("2 rebanadas de pan");
        ing26.add("Queso");
        ing26.add("Mantequilla");
        ArrayList<String> pasos26 = new ArrayList<>();
        pasos26.add("Unta mantequilla en las rebanadas de pan.");
        pasos26.add("Coloca queso entre las rebanadas.");
        pasos26.add("Cocina en una sarten hasta que este dorado.");
        pasos26.add("Sirve caliente.");
        listaReceta.add(new Recetas("Sandwich de Queso a la Parrilla", ing26, pasos26, 10));

        // Receta 27: Sopa de Lentejas
        ArrayList<String> ing27 = new ArrayList<>();
        ing27.add("1 taza de lentejas");
        ing27.add("Zanahorias");
        ing27.add("Cebolla");
        ing27.add("Caldo");
        ing27.add("Especias");
        ArrayList<String> pasos27 = new ArrayList<>();
        pasos27.add("Sofri la cebolla y las zanahorias.");
        pasos27.add("Anade las lentejas, el caldo y las especias.");
        pasos27.add("Cocina a fuego lento durante 30 minutos.");
        pasos27.add("Licua si lo deseas y sirve.");
        listaReceta.add(new Recetas("Sopa de Lentejas", ing27, pasos27, 40));

        // Receta 28: Brownie
        ArrayList<String> ing28 = new ArrayList<>();
        ing28.add("200g de chocolate");
        ing28.add("150g de mantequilla");
        ing28.add("200g de azucar");
        ing28.add("3 huevos");
        ing28.add("100g de harina");
        ArrayList<String> pasos28 = new ArrayList<>();
        pasos28.add("Derrite el chocolate y la mantequilla.");
        pasos28.add("Mezcla con azucar, huevos y harina.");
        pasos28.add("Hornea a 180C durante 25 minutos.");
        pasos28.add("Enfria y corta en cuadrados.");
        listaReceta.add(new Recetas("Brownie", ing28, pasos28, 35));

        // Receta 29: Ensalada Cobb
        ArrayList<String> ing29 = new ArrayList<>();
        ing29.add("Lechuga");
        ing29.add("Pollo");
        ing29.add("Tocino");
        ing29.add("Huevos");
        ing29.add("Aguacate");
        ing29.add("Aderezo");
        ArrayList<String> pasos29 = new ArrayList<>();
        pasos29.add("Coloca lechuga en un plato.");
        pasos29.add("Cubre con pollo picado, tocino, huevos y aguacate.");
        pasos29.add("Rocia con aderezo.");
        pasos29.add("Sirve fresco.");
        listaReceta.add(new Recetas("Ensalada Cobb", ing29, pasos29, 15));

        // Receta 30: Pudin de Chia
        ArrayList<String> ing30 = new ArrayList<>();
        ing30.add("1/4 taza de semillas de chia");
        ing30.add("1 taza de leche");
        ing30.add("Miel");
        ing30.add("Frutas");
        ArrayList<String> pasos30 = new ArrayList<>();
        pasos30.add("Mezcla las semillas de chia, la leche y la miel.");
        pasos30.add("Refrigera durante la noche.");
        pasos30.add("Cubre con frutas.");
        pasos30.add("Sirve frio.");
        listaReceta.add(new Recetas("Pudin de Chia", ing30, pasos30, 5));

        // Receta 31: Lasana
        ArrayList<String> ing31 = new ArrayList<>();
        ing31.add("Hojas de lasana");
        ing31.add("Carne molida");
        ing31.add("Salsa de tomate");
        ing31.add("Queso");
        ing31.add("Bechamel");
        ArrayList<String> pasos31 = new ArrayList<>();
        pasos31.add("Cocina la carne con la salsa.");
        pasos31.add("Coloca capas de hojas, carne, bechamel y queso.");
        pasos31.add("Hornea a 180C durante 40 minutos.");
        pasos31.add("Deja reposar antes de servir.");
        listaReceta.add(new Recetas("Lasana", ing31, pasos31, 60));

        // Receta 32: Huevos Fritos
        ArrayList<String> ing32 = new ArrayList<>();
        ing32.add("2 huevos");
        ing32.add("Mantequilla");
        ing32.add("Sal");
        ing32.add("Pimienta");
        ArrayList<String> pasos32 = new ArrayList<>();
        pasos32.add("Calienta mantequilla en una sarten.");
        pasos32.add("Rompe los huevos en la sarten.");
        pasos32.add("Cocina hasta que las claras esten firmes.");
        pasos32.add("Sazona y sirve.");
        listaReceta.add(new Recetas("Huevos Fritos", ing32, pasos32, 5));

        // Receta 33: Ratatouille
        ArrayList<String> ing33 = new ArrayList<>();
        ing33.add("Berenjena");
        ing33.add("Calabacin");
        ing33.add("Tomate");
        ing33.add("Cebolla");
        ing33.add("Hierbas");
        ArrayList<String> pasos33 = new ArrayList<>();
        pasos33.add("Corta las verduras en rodajas finas.");
        pasos33.add("Colocalas en un molde para hornear.");
        pasos33.add("Rocia aceite y hierbas.");
        pasos33.add("Hornea a 190C durante 45 minutos.");
        listaReceta.add(new Recetas("Ratatouille", ing33, pasos33, 60));

        // Receta 34: Muffins
        ArrayList<String> ing34 = new ArrayList<>();
        ing34.add("200g de harina");
        ing34.add("100g de azucar");
        ing34.add("1 huevo");
        ing34.add("Leche");
        ing34.add("Arandanos");
        ArrayList<String> pasos34 = new ArrayList<>();
        pasos34.add("Mezcla los ingredientes secos.");
        pasos34.add("Anade los ingredientes humedos y arandanos.");
        pasos34.add("Llena moldes para muffins.");
        pasos34.add("Hornea a 180C durante 20 minutos.");
        listaReceta.add(new Recetas("Muffins de Arandanos", ing34, pasos34, 30));

        // Receta 35: Rollos de Sushi
        ArrayList<String> ing35 = new ArrayList<>();
        ing35.add("Arroz para sushi");
        ing35.add("Nori");
        ing35.add("Pescado o verduras");
        ing35.add("Salsa de soja");
        ArrayList<String> pasos35 = new ArrayList<>();
        pasos35.add("Esparce arroz sobre el nori.");
        pasos35.add("Anade rellenos.");
        pasos35.add("Enrolla firmemente.");
        pasos35.add("Corta y sirve con salsa de soja.");
        listaReceta.add(new Recetas("Rollos de Sushi", ing35, pasos35, 30));

        // Receta 36: Tortilla
        ArrayList<String> ing36 = new ArrayList<>();
        ing36.add("3 huevos");
        ing36.add("Queso");
        ing36.add("Jamon");
        ing36.add("Verduras");
        ArrayList<String> pasos36 = new ArrayList<>();
        pasos36.add("Bate los huevos.");
        pasos36.add("Vierte en una sarten caliente.");
        pasos36.add("Anade los rellenos y dobla.");
        pasos36.add("Cocina hasta que este firme.");
        listaReceta.add(new Recetas("Tortilla", ing36, pasos36, 10));

        // Receta 37: Paella
        ArrayList<String> ing37 = new ArrayList<>();
        ing37.add("Arroz");
        ing37.add("Mariscos");
        ing37.add("Pollo");
        ing37.add("Azafran");
        ing37.add("Verduras");
        ArrayList<String> pasos37 = new ArrayList<>();
        pasos37.add("Sofri las proteinas y las verduras.");
        pasos37.add("Anade el arroz y el caldo con azafran.");
        pasos37.add("Cocina a fuego lento hasta que el arroz absorba el liquido.");
        pasos37.add("Deja reposar y sirve.");
        listaReceta.add(new Recetas("Paella", ing37, pasos37, 45));

        // Receta 38: Sundae de Helado
        ArrayList<String> ing38 = new ArrayList<>();
        ing38.add("Helado");
        ing38.add("Toppings");
        ing38.add("Crema batida");
        ing38.add("Cereza");
        ArrayList<String> pasos38 = new ArrayList<>();
        pasos38.add("Coloca helado en un tazon.");
        pasos38.add("Anade toppings.");
        pasos38.add("Cubre con crema batida y una cereza.");
        pasos38.add("Sirve inmediatamente.");
        listaReceta.add(new Recetas("Sundae de Helado", ing38, pasos38, 5));

        // Receta 39: Falafel
        ArrayList<String> ing39 = new ArrayList<>();
        ing39.add("Garbanzos");
        ing39.add("Hierbas");
        ing39.add("Especias");
        ing39.add("Aceite");
        ArrayList<String> pasos39 = new ArrayList<>();
        pasos39.add("Tritura los garbanzos con hierbas y especias.");
        pasos39.add("Forma bolas.");
        pasos39.add("Fria hasta que esten doradas.");
        pasos39.add("Sirve en pan de pita con salsa.");
        listaReceta.add(new Recetas("Falafel", ing39, pasos39, 30));

        // Receta 40: Waffles
        ArrayList<String> ing40 = new ArrayList<>();
        ing40.add("Harina");
        ing40.add("Leche");
        ing40.add("Huevos");
        ing40.add("Mantequilla");
        ing40.add("Polvo de hornear");
        ArrayList<String> pasos40 = new ArrayList<>();
        pasos40.add("Mezcla los ingredientes en una masa.");
        pasos40.add("Precalienta la wafflera.");
        pasos40.add("Vierte la masa y cocina hasta que este crujiente.");
        pasos40.add("Sirve con toppings.");
        listaReceta.add(new Recetas("Waffles", ing40, pasos40, 20));

        // Receta 41: Pollo al Curry
        ArrayList<String> ing41 = new ArrayList<>();
        ing41.add("Pollo");
        ing41.add("Pasta de curry");
        ing41.add("Leche de coco");
        ing41.add("Verduras");
        ArrayList<String> pasos41 = new ArrayList<>();
        pasos41.add("Sofri el pollo y la pasta de curry.");
        pasos41.add("Anade leche de coco y verduras.");
        pasos41.add("Cocina a fuego lento hasta que este listo.");
        pasos41.add("Sirve con arroz.");
        listaReceta.add(new Recetas("Pollo al Curry", ing41, pasos41, 30));

        // Receta 42: Palomitas
        ArrayList<String> ing42 = new ArrayList<>();
        ing42.add("Granos de maiz");
        ing42.add("Aceite");
        ing42.add("Sal");
        ArrayList<String> pasos42 = new ArrayList<>();
        pasos42.add("Calienta aceite en una olla.");
        pasos42.add("Anade los granos y tapa.");
        pasos42.add("Sacude hasta que dejen de explotar.");
        pasos42.add("Sazona con sal.");
        listaReceta.add(new Recetas("Palomitas", ing42, pasos42, 10));

        // Receta 43: Risotto
        ArrayList<String> ing43 = new ArrayList<>();
        ing43.add("Arroz Arborio");
        ing43.add("Caldo");
        ing43.add("Cebolla");
        ing43.add("Queso Parmesano");
        ing43.add("Vino blanco");
        ArrayList<String> pasos43 = new ArrayList<>();
        pasos43.add("Sofri la cebolla.");
        pasos43.add("Anade el arroz y el vino, luego el caldo gradualmente.");
        pasos43.add("Revuelve hasta que este cremoso.");
        pasos43.add("Mezcla con Parmesano.");
        listaReceta.add(new Recetas("Risotto", ing43, pasos43, 40));

        // Receta 44: Pan de Platano
        ArrayList<String> ing44 = new ArrayList<>();
        ing44.add("3 platanos");
        ing44.add("Harina");
        ing44.add("Azucar");
        ing44.add("Huevos");
        ing44.add("Mantequilla");
        ArrayList<String> pasos44 = new ArrayList<>();
        pasos44.add("Tritura los platanos.");
        pasos44.add("Mezcla con ingredientes humedos y secos.");
        pasos44.add("Hornea a 180C durante 50 minutos.");
        pasos44.add("Enfria antes de cortar.");
        listaReceta.add(new Recetas("Pan de Platano", ing44, pasos44, 60));

        // Receta 45: Guacamole
        ArrayList<String> ing45 = new ArrayList<>();
        ing45.add("3 aguacates");
        ing45.add("Lima");
        ing45.add("Cebolla");
        ing45.add("Tomate");
        ing45.add("Cilantro");
        ArrayList<String> pasos45 = new ArrayList<>();
        pasos45.add("Tritura los aguacates.");
        pasos45.add("Mezcla con ingredientes picados y jugo de lima.");
        pasos45.add("Sazona al gusto.");
        pasos45.add("Sirve con totopos.");
        listaReceta.add(new Recetas("Guacamole", ing45, pasos45, 10));

        // Receta 46: Albondigas
        ArrayList<String> ing46 = new ArrayList<>();
        ing46.add("Carne molida");
        ing46.add("Pan rallado");
        ing46.add("Huevo");
        ing46.add("Especias");
        ing46.add("Salsa");
        ArrayList<String> pasos46 = new ArrayList<>();
        pasos46.add("Mezcla la carne con los ingredientes.");
        pasos46.add("Forma bolas.");
        pasos46.add("Hornea o fri.");
        pasos46.add("Cocina a fuego lento en salsa.");
        listaReceta.add(new Recetas("Albondigas", ing46, pasos46, 30));

        // Receta 47: Gazpacho
        ArrayList<String> ing47 = new ArrayList<>();
        ing47.add("Tomates");
        ing47.add("Pepino");
        ing47.add("Pimiento");
        ing47.add("Ajo");
        ing47.add("Aceite de oliva");
        ArrayList<String> pasos47 = new ArrayList<>();
        pasos47.add("Licua todos los ingredientes.");
        pasos47.add("Refrigera durante horas.");
        pasos47.add("Sirve frio.");
        pasos47.add("Decora con hierbas.");
        listaReceta.add(new Recetas("Gazpacho", ing47, pasos47, 15));

        // Receta 48: Crepas
        ArrayList<String> ing48 = new ArrayList<>();
        ing48.add("Harina");
        ing48.add("Leche");
        ing48.add("Huevos");
        ing48.add("Mantequilla");
        ArrayList<String> pasos48 = new ArrayList<>();
        pasos48.add("Bate la masa.");
        pasos48.add("Vierte una capa fina en la sarten.");
        pasos48.add("Cocina ambos lados.");
        pasos48.add("Rellena con toppings.");
        listaReceta.add(new Recetas("Crepas", ing48, pasos48, 20));

        // Receta 49: Hummus
        ArrayList<String> ing49 = new ArrayList<>();
        ing49.add("Garbanzos");
        ing49.add("Tahini");
        ing49.add("Limon");
        ing49.add("Ajo");
        ing49.add("Aceite de oliva");
        ArrayList<String> pasos49 = new ArrayList<>();
        pasos49.add("Licua todos los ingredientes.");
        pasos49.add("Ajusta el sazon.");
        pasos49.add("Rocia aceite.");
        pasos49.add("Sirve con pan de pita.");
        listaReceta.add(new Recetas("Hummus", ing49, pasos49, 10));

        // Receta 50: Tiramisu
        ArrayList<String> ing50 = new ArrayList<>();
        ing50.add("Bizcochos de soletilla");
        ing50.add("Queso mascarpone");
        ing50.add("Cafe");
        ing50.add("Huevos");
        ing50.add("Cocoa en polvo");
        ArrayList<String> pasos50 = new ArrayList<>();
        pasos50.add("Sumerge los bizcochos en cafe.");
        pasos50.add("Coloca capas con crema de mascarpone.");
        pasos50.add("Refrigera durante la noche.");
        pasos50.add("Espolvorea cocoa antes de servir.");
        listaReceta.add(new Recetas("Tiramisu", ing50, pasos50, 20));

        // Guardar en archivo
        File directorio = new File("Recetas");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        String ruta = "Recetas/recetas.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(listaReceta);
            System.out.println("50 recetas guardadas en " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}