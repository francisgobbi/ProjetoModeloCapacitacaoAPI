package TestSuites;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import TestCases.BuscarProdutoComTokenTest;


@Suite
@SelectClasses({BuscarProdutoComTokenTest.class})
public class PositiveTests {

}
