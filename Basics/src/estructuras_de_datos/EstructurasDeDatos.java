package estructuras_de_datos;

import java.util.*;

public class EstructurasDeDatos {
    public static void main(String[] args) {


        // ========================================
        // 1. ARRAYS (Arreglos)
        // ========================================
        System.out.println("=== ARRAYS ===");

        // Declaración e inicialización
        int[] numeros = {1, 2, 3, 4, 5};
        String[] nombres = new String[3];
        nombres[0] = "Ana";
        nombres[1] = "Luis";
        nombres[2] = "María";

        // Acceso y modificación
        System.out.println("Primer elemento: " + numeros[0]);
        numeros[0] = 10;
        System.out.println("Longitud: " + numeros.length);

        // Recorrido
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        // Recorrido mediante foreach
        for (String nombre : nombres) {
            System.out.print(nombre + " ");
        }
        System.out.println();

        // Array multidimensional
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Matriz[1][2]: " + matriz[1][2]);

        // Métodos útiles de Arrays
        int[] arr = {5, 2, 8, 1, 9};
        Arrays.sort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
        System.out.println("Búsqueda binaria de 8: " + Arrays.binarySearch(arr, 8));


        // ========================================
        // 2. ARRAYLIST (Lista Dinámica)
        // ========================================
        System.out.println("\n=== ARRAYLIST ===");

        ArrayList<String> lista = new ArrayList<>();

        // Agregar elementos
        lista.add("Java");
        lista.add("Python");
        lista.add("JavaScript");
        lista.add(1, "C++"); // Insertar en posición
        System.out.println("ArrayList: " + lista);

        // Acceso y modificación
        System.out.println("Elemento en índice 0: " + lista.get(0));
        lista.set(0, "Go");
        System.out.println("Después de set: " + lista);

        // Eliminar elementos
        lista.remove("Python");
        lista.remove(0);
        System.out.println("Después de eliminar: " + lista);

        // Tamaño y verificaciones
        System.out.println("Tamaño: " + lista.size());
        System.out.println("¿Contiene Java?: " + lista.contains("Java"));
        System.out.println("¿Está vacío?: " + lista.isEmpty());

        // Recorrido
        for (String lenguaje : lista) {
            System.out.print(lenguaje + " ");
        }
        System.out.println();


        // ========================================
        // 3. LINKEDLIST (Lista Enlazada)
        // ========================================
        System.out.println("\n=== LINKEDLIST ===");

        LinkedList<Integer> linkedList = new LinkedList<>();

        // Operaciones de lista
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        // Operaciones específicas de LinkedList
        linkedList.addFirst(5);
        linkedList.addLast(40);
        System.out.println("LinkedList: " + linkedList);

        System.out.println("Primer elemento: " + linkedList.getFirst());
        System.out.println("Último elemento: " + linkedList.getLast());

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Después de remover primero y último: " + linkedList);


        // ========================================
        // 4. STACK (Pila - LIFO)
        // ========================================
        System.out.println("\n=== STACK ===");

        Stack<String> pila = new Stack<>();

        // Push (apilar)
        pila.push("Plato 1");
        pila.push("Plato 2");
        pila.push("Plato 3");
        System.out.println("Stack: " + pila);

        // Peek (ver el tope sin eliminar)
        System.out.println("Tope: " + pila.peek());

        // Pop (desapilar)
        System.out.println("Pop: " + pila.pop());
        System.out.println("Stack después de pop: " + pila);

        // Verificaciones
        System.out.println("¿Está vacío?: " + pila.empty());
        System.out.println("Posición de 'Plato 1': " + pila.search("Plato 1"));


        // ========================================
        // 5. QUEUE (Cola - FIFO)
        // ========================================
        System.out.println("\n=== QUEUE ===");

        Queue<String> cola = new LinkedList<>();

        // Offer (encolar)
        cola.offer("Cliente 1");
        cola.offer("Cliente 2");
        cola.offer("Cliente 3");
        System.out.println("Queue: " + cola);

        // Peek (ver el frente)
        System.out.println("Frente: " + cola.peek());

        // Poll (desencolar)
        System.out.println("Poll: " + cola.poll());
        System.out.println("Queue después de poll: " + cola);


        // ========================================
        // 6. PRIORITYQUEUE (Cola con Prioridad)
        // ========================================
        System.out.println("\n=== PRIORITYQUEUE ===");

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>();

        colaPrioridad.add(30);
        colaPrioridad.add(10);
        colaPrioridad.add(20);

        System.out.println("PriorityQueue: " + colaPrioridad);
        System.out.println("Poll (menor primero): " + colaPrioridad.poll());
        System.out.println("Poll: " + colaPrioridad.poll());


        // ========================================
        // 7. HASHSET (Conjunto sin duplicados)
        // ========================================
        System.out.println("\n=== HASHSET ===");

        HashSet<String> conjunto = new HashSet<>();

        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); // No se agrega (duplicado)
        System.out.println("HashSet: " + conjunto);
        System.out.println("Tamaño: " + conjunto.size());

        // Operaciones de conjunto
        System.out.println("¿Contiene Banana?: " + conjunto.contains("Banana"));
        conjunto.remove("Banana");
        System.out.println("Después de remover: " + conjunto);

        // Recorrido
        for (String fruta : conjunto) {
            System.out.print(fruta + " ");
        }
        System.out.println();


        // ========================================
        // 8. LINKED HASHSET (Set con orden de inserción)
        // ========================================
        System.out.println("\n=== LINKED HASHSET ===");

        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(3);
        linkedSet.add(1);
        linkedSet.add(2);
        System.out.println("LinkedHashSet (mantiene orden): " + linkedSet);


        // ========================================
        // 9. TREE SET (Set ordenado)
        // ========================================
        System.out.println("\n=== TREE SET ===");

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        System.out.println("TreeSet (ordenado): " + treeSet);

        System.out.println("Primero: " + treeSet.first());
        System.out.println("Último: " + treeSet.last());
        System.out.println("Menor que 50: " + treeSet.lower(50));
        System.out.println("Mayor que 20: " + treeSet.higher(20));


        // ========================================
        // 10. HASHMAP (Mapa clave-valor)
        // ========================================
        System.out.println("\n=== HASHMAP ===");

        HashMap<String, Integer> mapa = new HashMap<>();

        // Agregar pares clave-valor
        mapa.put("Juan", 25);
        mapa.put("María", 30);
        mapa.put("Pedro", 28);
        System.out.println("HashMap: " + mapa);

        // Acceso
        System.out.println("Edad de Juan: " + mapa.get("Juan"));
        System.out.println("¿Contiene clave 'Ana'?: " + mapa.containsKey("Ana"));
        System.out.println("¿Contiene valor 30?: " + mapa.containsValue(30));

        // Modificar
        mapa.put("Juan", 26); // Actualizar valor
        mapa.putIfAbsent("Ana", 22); // Solo si no existe
        System.out.println("Después de modificar: " + mapa);

        // Eliminar
        mapa.remove("Pedro");
        System.out.println("Después de eliminar: " + mapa);

        // Recorrido
        System.out.println("Recorrido por entradas:");
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        System.out.println("Solo claves: " + mapa.keySet());
        System.out.println("Solo valores: " + mapa.values());


        // ========================================
        // 11. LINKED HASHMAP (Map con orden de inserción)
        // ========================================
        System.out.println("\n=== LINKED HASHMAP ===");

        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("uno", "1");
        linkedMap.put("dos", "2");
        linkedMap.put("tres", "3");
        System.out.println("LinkedHashMap (mantiene orden): " + linkedMap);


        // ========================================
        // 12. TREEMAP (Map ordenado por clave)
        // ========================================
        System.out.println("\n=== TREEMAP ===");

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Tres");
        treeMap.put(1, "Uno");
        treeMap.put(2, "Dos");
        System.out.println("TreeMap (ordenado por clave): " + treeMap);

        System.out.println("Primera clave: " + treeMap.firstKey());
        System.out.println("Última clave: " + treeMap.lastKey());


        // ========================================
        // 13. COMPARACIÓN Y CONVERSIONES
        // ========================================
        System.out.println("\n=== CONVERSIONES ===");

        // Array a ArrayList
        String[] arrayNombres = {"Ana", "Luis", "María"};
        ArrayList<String> listaNombres = new ArrayList<>(Arrays.asList(arrayNombres));
        System.out.println("Array a ArrayList: " + listaNombres);

        // ArrayList a Array
        String[] nuevoArray = listaNombres.toArray(new String[0]);
        System.out.println("ArrayList a Array: " + Arrays.toString(nuevoArray));

        // Set a List
        List<Integer> listaDesdeSet = new ArrayList<>(treeSet);
        System.out.println("Set a List: " + listaDesdeSet);


        // ========================================
        // 14. OPERACIONES ÚTILES CON COLLECTIONS
        // ========================================
        System.out.println("\n=== OPERACIONES COLLECTIONS ===");

        List<Integer> listaNum = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));

        // Ordenar
        Collections.sort(listaNum);
        System.out.println("Ordenado: " + listaNum);

        // Invertir
        Collections.reverse(listaNum);
        System.out.println("Invertido: " + listaNum);

        // Mezclar aleatoriamente
        Collections.shuffle(listaNum);
        System.out.println("Mezclado: " + listaNum);

        // Máximo y mínimo
        System.out.println("Máximo: " + Collections.max(listaNum));
        System.out.println("Mínimo: " + Collections.min(listaNum));

        // Frecuencia
        listaNum.add(9);
        System.out.println("Frecuencia de 9: " + Collections.frequency(listaNum, 9));

        // Llenar con un valor
        Collections.fill(listaNum, 0);
        System.out.println("Después de fill: " + listaNum);
    }
}
