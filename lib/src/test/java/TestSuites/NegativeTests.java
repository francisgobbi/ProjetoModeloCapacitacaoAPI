package TestSuites;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import TestCases.BuscarProdutoNegativeTest;


@Suite
@SelectClasses({BuscarProdutoNegativeTest.class})
public class NegativeTests {

}
