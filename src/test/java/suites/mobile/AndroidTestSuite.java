package suites.mobile;

import mobile.tests.android.AndroidMoviesTests;
import mobile.tests.android.AndroidSearchTests;
import mobile.tests.android.AndroidTvShowsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AndroidMoviesTests.class,
        AndroidTvShowsTests.class,
        AndroidSearchTests.class,
})

public class AndroidTestSuite {}
