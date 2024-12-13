//package Main;
//
//import junit.framework.TestCase;
//
//public class GroundTest extends TestCase {
//
//    public void testGenerateRandom() throws Exception {
//        Ground instance = new Ground();
//        int counter = 0;
//        for(int i=0; i<instance.getFieldSize(); i++){
//            if(instance.isItem(i))
//                counter++;
//        }
//        assertTrue("error di generateRandom Ground", counter >= 1 && counter <= instance.getFieldSize() / 2);
//    }
//
//    public void testGetDirection() throws Exception {
//        Ground instance = new Ground();
//        instance.setDirection(true);
//        assertTrue("error di setDirection", instance.getDirection());
//        instance.setDirection(false);
//        assertFalse("error di setDirection", instance.getDirection());
//    }
//
//    public void testSetDirection() throws Exception {
//        Ground instance = new Ground();
//        instance.setDirection(true);
//        assertTrue("error di setDirection", instance.getDirection());
//        instance.setDirection(false);
//        assertFalse("error di setDirection", instance.getDirection());
//    }
//
//    public void testGetFieldSize() throws Exception {
//        Ground instance = new Ground();
//        assertEquals("error di getFieldSize", instance.getFieldSize(), 7);
//    }
//
//    public void testMoveField() throws Exception {
//        Ground instance = new Ground();
//        Ground instanceTwo = new Ground(instance);
//
//        boolean trueInstance[] = new boolean[7];
//        boolean falseInstance[] = new boolean[7];
//
//        for(int i=0; i<6; i++){
//            trueInstance[i] = instance.isItem(i+1);
//        }
//        for(int i=0; i<6; i++){
//            falseInstance[i+1] = instanceTwo.isItem(i);
//        }
//
//        trueInstance[6] = instance.isItem(0);
//        falseInstance[0] = instanceTwo.isItem(6);
//
//        instance.setDirection(true);
//        instance.moveField();
//        instanceTwo.setDirection(false);
//        instanceTwo.moveField();
//        for(int i=0; i<7; i++){
//            assertEquals("error di moveField", instance.isItem(i), trueInstance[i]);
//            assertEquals("error di moveField", falseInstance[i], instanceTwo.isItem(i));
//        }
//    }
//
//    public void testIsItem() throws Exception {
//        Ground instance = new Ground();
//        instance.setItem(0, false);
//        instance.setItem(1, true);
//        assertFalse("error di isItem", instance.isItem(0));
//        assertTrue("error di isItem", instance.isItem(1));
//    }
//
//    public void testSetItem() throws Exception {
//        Ground instance = new Ground();
//        instance.setItem(0, false);
//        instance.setItem(1, true);
//        assertFalse("error di isItem", instance.isItem(0));
//        assertTrue("error di isItem", instance.isItem(1));
//    }
//}