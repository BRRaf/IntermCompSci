package lab01;
import org.junit.platform.runner.JUnitPlatform;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({InterrogatorTest.class, StatsTest.class, ResultsTest.class})


public class AllTests {}
