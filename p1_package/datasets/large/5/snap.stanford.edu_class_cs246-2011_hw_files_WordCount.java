import java io ioexception import java util import org apache hadoop fs path import org apache hadoop io import org apache hadoop mapred public class wordcount public static class map extends mapreducebase implements mapper longwritable text text intwritable private final static intwritable one new intwritable 1 private text word new text public void map longwritable key text value outputcollector text intwritable output reporter reporter throws ioexception string line value tostring stringtokenizer tokenizer new stringtokenizer line while tokenizer hasmoretokens word set tokenizer nexttoken output collect word one public static class reduce extends mapreducebase implements reducer text intwritable text intwritable public void reduce text key iterator intwritable values outputcollector text intwritable output reporter reporter throws ioexception int sum 0 while values hasnext sum values next get output collect key new intwritable sum public static void main string args throws ioexception jobconf conf new jobconf wordcount class conf setjobname wordcount conf setoutputkeyclass text class conf setoutputvalueclass intwritable class conf setmapperclass map class conf setreducerclass reduce class conf setinputformat textinputformat class conf setoutputformat textoutputformat class fileinputformat setinputpaths conf new path args 0 fileoutputformat setoutputpath conf new path args 1 try jobclient runjob conf catch ioexception e system err println e getmessage