package cases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mighty
 */
import com.shara.models.Network;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
public class NetworkTest {
    Network net = new Network("LLLLL");
    @Test
    public void testNetwork() throws IOException{
        assertEquals("LLLLL", net.connect());
    }
}
