package suites.mobile;

import application.AndroidMoviesTests;
import application.AndroidSearchTests;
import application.AndroidTvShowsTests;
import org.junit.RunWith;
import org.junit.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AndroidMoviesTests.class,
        AndroidTvShowsTests.class,
        AndroidSearchTests.class,
})

public class AndroidTestSuite {}
