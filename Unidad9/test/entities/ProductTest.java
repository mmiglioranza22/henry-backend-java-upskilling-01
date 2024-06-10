package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// GIVEN (contexto - variables necesarias para la prueba)
// WHEN (acción requerida a ser evaluada: esto es lo que tiene que funcionar como se espera)
// THEN (assertion: evalua la acción al resultado esperado)
@DisplayName("ProductTest suite")
class ProductTest {

    @Test
    public void testCreatesProductCorrectly() {

        int code = 100;
        String name = "papas";
        double price = 2500.0;

        Product product = new Product(code, name, 2500.0);

        Assertions.assertEquals(product.getCode(), code);
        Assertions.assertEquals(product.getName(), name);
        Assertions.assertEquals(product.getPrice(), price);

    }

}