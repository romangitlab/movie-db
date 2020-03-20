package suites.mobile;

import mobile.tests.mobile_web.MoviesTests;
import mobile.tests.mobile_web.SearchTests;
import mobile.tests.mobile_web.TvShowsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        MoviesTests.class,
        TvShowsTests.class,
        SearchTests.class,
})

public class MWTestSuite {}
