package steps;
import io.cucumber.java8.En;
import utilities.RestAssuredExtension;
import io.cucumber.htmlformatter.Main;



public class testInitialize implements En {
public testInitialize(){
    Before(() -> {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
        System.out.println( " Before Block Executed");
    });
}


}
