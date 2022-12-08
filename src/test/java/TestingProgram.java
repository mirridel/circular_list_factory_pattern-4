import data.Counter;
import data.structure.CircularList;
import data.types.UserFactory;
import data.types.UserType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestingProgram {

    ArrayList jl;
    CircularList<Object> cl;
    UserType p;

    int inputDataSize = 128000;

    @BeforeEach
    void setUp(){
        jl = new ArrayList<>();
        cl = new CircularList<>();
        p = UserFactory.getBuilderByName("Integer");
    }

    // Исходный набор содержит одинаковые значения
    @Test
    @Order(1)
    void testOne(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(1);
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(2)
    void defectedTestOne(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(1);
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // Исходный набор неупорядочен
    @Test
    @Order(3)
    void testTwo(){
        // p.create() возвращает Random().nextInt(100);
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(4)
    void defectedTestTwo(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // Исходный набор упорядочен в прямом порядке
    @Test
    @Order(5)
    void testThree(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(i);
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(6)
    void defectedTestThree(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(i);
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // Исходный набор упорядочен в обратном порядке
    @Test
    @Order(7)
    void testFour(){
        for (int i = inputDataSize; i > 0; i--)
            jl.add(i);
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(8)
    void defectedTestFour(){
        for (int i = inputDataSize; i > 0; i--)
            jl.add(i);
        jl.forEach(el->cl.add(el));
        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // В наборе имеются повторяющиеся значения
    @Test
    @Order(9)
    void testFive(){
        // p.create() возвращает Random().nextInt(100);
        inputDataSize = 128000;
        // при создании 128000 элементов будут повторяющиеся значения
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(10)
    void defectedTestFive(){
        // p.create() возвращает Random().nextInt(100);
        inputDataSize = 128000;
        // при создании 128000 элементов будут повторяющиеся значения
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // экстремальное значение находится в середине набора
    @Test
    @Order(11)
    void testSix(){
        int mid = inputDataSize / 2;
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(mid, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(12)
    void defectedTestSix(){
        int mid = inputDataSize / 2;
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(mid, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // экстремальное значение находится в начале набора
    @Test
    @Order(13)
    void testSeven(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(0, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(14)
    void defectedTestSeven(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(0, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // экстремальное значение находится в конце набора
    @Test
    @Order(15)
    void testEight(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(inputDataSize, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(16)
    void defectedTestEight(){
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(inputDataSize, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    // несколько экстремальных значений
    @Test
    @Order(17)
    void testNine(){
        int mid = inputDataSize / 2;
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(0, Integer.MAX_VALUE);
        jl.add(mid, Integer.MAX_VALUE);
        jl.add(inputDataSize, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.mergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(18)
    void defectedTestNine(){
        int mid = inputDataSize / 2;
        for (int i = 0; i < inputDataSize; i++)
            jl.add(p.create());
        jl.add(0, Integer.MAX_VALUE);
        jl.add(mid, Integer.MAX_VALUE);
        jl.add(inputDataSize, Integer.MAX_VALUE);
        jl.forEach(el->cl.add(el));

        Collections.sort(jl);
        CircularList<Object> clSorted = cl.defectedMergeSort(p.getTypeComparator());
        Assertions.assertEquals(jl.toString(), clSorted.toString());
    }

    @Test
    @Order(19)
    void testTimeAndOperations() {
        System.err.println("Testing the time and number of operations performed");
        for (int i = 1; i <= Math.pow(2,12); i *= 2) {
            int n = i * 10000;
            Counter count = new Counter();
            System.out.println("N = " + n);
            CircularList<Object> list = new CircularList<>();
            for (int j = 0; j < n; j++) list.add(p.create());
            long start = System.nanoTime();
            try {
                list.mergeSort(p.getTypeComparator(), count);
            } catch (StackOverflowError ignored) {
                System.err.println("Stack error on " + n);
                return;
            }
            long end = System.nanoTime();
            System.out.println("Seconds elapsed " + (end - start) * 1.0 / 1_000_000_000);
            System.out.println("Count operations " + count.getCount());
        }
    }

    @Test
    @Disabled()
    void testOverflow() {
        for (int i = (int) Math.pow(2,8); i <= (int) Math.pow(2,64); i *= 2) {
            int n = i * 10000;
            System.out.println("N = " + n + " ");
            CircularList<Object> list = new CircularList<>();
            for (int j = 0; j < n; j++) list.add(p.create());
            try {
                list.mergeSort(p.getTypeComparator());
            }
            catch (Exception e) {
                fail("Exception on  N = " + n);
                return;
            }
            catch (Error e) {
                fail("Error on N = " + n);
                return;
            }
        }
    }
}
