//package Main;
//
//import junit.framework.TestCase;
//
///**
// * Created by omarcelh on 13-Apr-15.
// */
//public class PointTest extends TestCase {
//
//    public void testGetAbsis() throws Exception {
//        Point instance = new Point();
//        assertEquals("error di getAbsis", 0, instance.getAbsis());
//    }
//
//    public void testGetOrdinat() throws Exception {
//        Point instance = new Point();
//        assertEquals("error di getOrdinat", 0, instance.getOrdinat());
//    }
//
//    public void testSetAbsis() throws Exception {
//        Point instance = new Point();
//        instance.setAbsis(2);
//        assertEquals("error di setAbsis", 2, instance.getAbsis());
//    }
//
//    public void testSetOrdinat() throws Exception {
//        Point instance = new Point();
//        instance.setOrdinat(3);
//        assertEquals("error di setOrdinat", 3, instance.getOrdinat());
//    }
//
//    public void testSetPoint() throws Exception {
//        Point instance = new Point();
//        instance.setPoint(2,3);
//        assertEquals("error di setPoint", 2, instance.getAbsis());
//        assertEquals("error di setPoint", 3, instance.getOrdinat());
//    }
//
//    public void testToString() throws Exception {
//        Point instance = new Point(2,3);
//        String result = "(" + instance.getAbsis() + ", " + instance.getOrdinat() + ")";
//        assertEquals("error di toString", result, instance.toString());
//    }
//}