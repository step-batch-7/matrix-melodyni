# /bin/sh
set -e;

echo "cleaning...."
rm -rf out;
mkdir out;
echo "compiling....\n" 
javac -d out -cp out:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar $(find . -name "*.java");