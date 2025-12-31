Files:

Stream<Path> paths = Files.walk(Paths.get("path"));

accepts path as input
return stream of all file path for given input directory as output

note: 
Files.list(path) -> only direct children
Files.walk(path) → recursive, includes subfolders



Files.isRegularFile
check is it a file or not

paths.filter(e -> Files.isRegularFile(e));



Files.lines
takes out each line by line from a file

Files.lines(path).forEach(line -> { ...})



Files.readString
Read whole file at once.
String text = Files.readString(path);