package TestSuites;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import TestCases.BuscarApenasUmProdutoPorIdTest;


@Suite
@SelectClasses({BuscarApenasUmProdutoPorIdTest.class})
public class PositiveTests {

}
