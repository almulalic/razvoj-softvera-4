package ba.unsa.etf.rs.tut4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.Assert.*;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)

class UITest {
    @Start
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/UI.fxml"));
        stage.setTitle("Tutorijal 3");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setMinHeight(120);
        stage.setMinWidth(200);
        stage.show();
        stage.toFront();
    }

    @Test
    void TestJedanArtikal(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        TextArea filtriraniArtikli = robot.lookup("#filtiraniArtikli").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("HLB001,Crni hljeb,1\n");
        robot.clickOn("#dodajArtikal");
        assertEquals("HLB001 Crni hljeb 1.00\n",filtriraniArtikli.getText());
    }

    @Test
    void TestPrimjerTutorial(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        TextArea filtriraniArtikli = robot.lookup("#filtiraniArtikli").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.20\n" +
                "MLK001,Mlijeko Meggle,1.10\n");
        robot.clickOn("#dodajArtikal");
        assertEquals("HLB001 Crni hljeb 1.00\n" +
                "HLB002 Bijeli hljeb 1.20\n" +
                "MLK001 Mlijeko Meggle 1.10\n" , filtriraniArtikli.getText());
    }

    @Test
    void TestIzbacivanjaDuplikata(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        TextArea filtriraniArtikli = robot.lookup("#filtiraniArtikli").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.20\n" +
                "MLK001,Mlijeko Meggle,1.10\n" +
                "HLB001,Crni hljeb,1\n" +
                "HLB001,Crni hljeb,1\n" +
                "MLK001,Mlijeko Meggle,1.10\n" +
                "MLK001,Mlijeko Meggle,1.10\n" +
                "MLK001,Mlijeko Meggle,1.10\n");
        robot.clickOn("#dodajArtikal");
        assertEquals("HLB001 Crni hljeb 1.00\n" +
                "HLB002 Bijeli hljeb 1.20\n" +
                "MLK001 Mlijeko Meggle 1.10\n" , filtriraniArtikli.getText());
    }

    @Test
    void TestDropdown(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        ChoiceBox choiceBox = robot.lookup("#choiceBox").queryAs(ChoiceBox.class);

        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.write("");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl).press(KeyCode.DELETE);
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.20\n" +
                "MLK001,Mlijeko Meggle,1.10\n");
        robot.clickOn("#dodajArtikal");
        robot.clickOn("#tabRacun");
        assertTrue(choiceBox.getItems().get(2).equals("MLK001"));
    }

    @Test
    void TestKolicina(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        TextArea aktuelniUnos = robot.lookup("#aktuelniRacun").queryAs(TextArea.class);
        Spinner kolicina = robot.lookup("#kolicina").queryAs(Spinner.class);

        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.write("");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl).press(KeyCode.DELETE);
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.20\n" +
                "MLK001,Mlijeko Meggle,1.10\n");
        robot.clickOn("#dodajArtikal");
        robot.clickOn("#tabRacun");

        robot.clickOn("#kolicina");
        robot.press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP);
        assertEquals(kolicina.getValue(),5);
    }

    @Test
    void TestPrazno(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        TextArea aktuelniUnos = robot.lookup("#aktuelniRacun").queryAs(TextArea.class);

        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.write("");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl).press(KeyCode.DELETE);
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.20\n" +
                "MLK001,Mlijeko Meggle,1.10\n");
        robot.clickOn("#dodajArtikal");
        robot.clickOn("#tabRacun");

        robot.clickOn("#dodajNaRacun");
        assertEquals(aktuelniUnos.getText(),"UKUPNO\t\t0.00");
    }

    @Test
    void TestRacunOutput(FxRobot robot) {
        TextArea unosArtikala = robot.lookup("#unosArtikala").queryAs(TextArea.class);
        Button dodajButton = robot.lookup("#dodajArtikal").queryAs(Button.class);
        TextArea aktuelniUnos = robot.lookup("#aktuelniRacun").queryAs(TextArea.class);

        assertNotNull(dodajButton);
        robot.clickOn(unosArtikala);

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;

        robot.write("");
        robot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl).press(KeyCode.DELETE);
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.20\n" +
                "MLK001,Mlijeko Meggle,1.10\n");
        robot.clickOn("#dodajArtikal");
        robot.clickOn("#tabRacun");
        robot.clickOn("#choiceBox");
        robot.press(KeyCode.DOWN).release(KeyCode.DOWN).press(KeyCode.DOWN).release(KeyCode.DOWN).press(KeyCode.ENTER).release(KeyCode.DOWN);
        robot.clickOn("#kolicina");
        robot.press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP);
        robot.clickOn("#dodajNaRacun");
        assertEquals(aktuelniUnos.getText(),"MLK001\t4\t4.40\n" + "UKUPNO\t\t4.40");
    }

}