Convert Compile Exception to Runtime Exception
try{}
catch (ClassNotFoundException e) {
  throw new RuntimeException(e);
}

try with Resource
try(FileOutputStream fileOutputStream =newFileOutputStream("/java7-new-features/src/abc.txt"))

