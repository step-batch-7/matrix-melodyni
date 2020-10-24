# /bin/sh
set -euo pipefail;

TESTNAMES=`find test -name "*Test.java" | sed "s/test\///" | sed "s/.java//" | tr "/" "."`

echo "running tests....\n";
java -cp out:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore $TESTNAMES;