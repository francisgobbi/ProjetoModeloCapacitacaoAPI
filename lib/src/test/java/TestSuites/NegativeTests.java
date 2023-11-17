package TestSuites;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import TestCases.BuscarProdutoPorIdNegativeTest;


@Suite
@SelectClasses({BuscarProdutoPorIdNegativeTest.class})
public class NegativeTests {

}
