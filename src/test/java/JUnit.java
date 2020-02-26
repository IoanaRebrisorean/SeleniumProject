import org.junit.*;

public class JUnit {
    @BeforeClass
    public static void beforeClass(){
        System.out.println(" in before class ");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println(" in after class ");
    }

    @Before
    public void before(){
        System.out.println(" in before ");
    }

    @After
    public void after(){
        System.out.println( " in after ");
    }

    @Test
    public void test(){
        System.out.println(" in test ");
    }

    @Test
    public void altTest(){
        System.out.println(" in test 2");
    }

    @Ignore
    public void ignoreTest(){
        System.out.println( " in ignore test ");
    }
}
