package services;

import entities.Product;
import entities.ShoppingCart;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ProductServiceImpl suite")
//Indicarle al test que se va a usar mockito
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    //    Mock de las dependencias a ser injectadas. Estas son las que se abstraen para que devuelvan lo que necesitamos a los efectos del test (ej: repositorios, etc)
    @Mock
    private ShoppingCart cart;

    //    Injecta el constructor de la clase a ser testeada: la implementación de ProductService
    @InjectMocks
    private ProductServiceImpl service;

//    otra forma de inicializar los mocks
//    @BeforeEach
//    public void setUp() {
//        cart = Mockito.mock(ShoppingCart.class);
//        service = new ProductServiceImpl(cart);

//     //   service = new ProductServiceImpl(new ShoppingCart());

//    }

    @DisplayName("Agrega un producto N veces")
    @Test
    public void testAgregarProductoAlCarrito() {
//        GIVEN
        Product producto = new Product(100, "papas", 200.0);
        int timesCalled = 5;

//        WHEN
        service.addProductToCart(producto, timesCalled);

//        THEN
        Mockito.verify(service.getCart(), Mockito.times(timesCalled)).addProduct(producto);

    }

}