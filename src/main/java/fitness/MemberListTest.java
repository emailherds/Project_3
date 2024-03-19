//package fitness;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class MemberListTest {
//    @Test
//    public void test1() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Basic(johnProfile, d, location, 0);
//        assertTrue(ml.add(John));
//    }
//    @Test
//    public void test2() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Basic(johnProfile, d, location, 0);
//        ml.add(John);
//        assertFalse(ml.add(John));
//    }
//    @Test
//    public void test3() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Family(johnProfile, d, location, true);
//        assertTrue(ml.add(John));
//    }
//    @Test
//    public void test4() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Family(johnProfile, d, location, true);
//        ml.add(John);
//        assertFalse(ml.add(John));
//    }
//    @Test
//    public void test5() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Premium(johnProfile, d, location, 2);
//        assertTrue(ml.add(John));
//    }
//    @Test
//    public void test6() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Premium(johnProfile, d, location, 2);
//        ml.add(John);
//        assertFalse(ml.add(John));
//    }
//    @Test
//    public void test7() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Premium(johnProfile, d, location, 2);
//        ml.add(John);
//        assertTrue(ml.remove(John));
//    }
//    @Test
//    public void test8() {
//        MemberList ml = new MemberList();
//        Profile johnProfile = new Profile("John", "Doe", new Date(11, 2, 2000));
//        Location location = Location.BRIDGEWATER;
//        Date d = new Date(11, 2, 2025);
//        Member John = new Premium(johnProfile, d, location, 2);
//        ml.remove(John);
//        assertFalse(ml.remove(John));
//    }
//}