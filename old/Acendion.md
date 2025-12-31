1) Permutation program
input: abc
output: abc, acb, bac, bca, cab, cba
Solution -> recrusion
main(){
	method("", abc);
}
method(String prefix, String str){
	if(str.length()==0) Sysout(prefix);
	else{
		for(int i=0; i<str.length();i++){
		method(prefix+str.charAt(i), str.subString(0,i)+str.subString(i+1, n));
		}
	}
}

2) Spy() in Mockito :
Mockito internally uses Reflection API to mock the data
Spy() is used to check wheter the interaction took place or not
ArrayList<Integer> spy = Mockito.spy(new ArrayList<>());
Mockito.verify(spy).add(1)
assertEqual(1, spy.size())

3) How to do testing for Static and Private mehods:
Mockito will not support it. So we use PowerMockito
verifyStatic and verifyPrivate methods are there

4) System.exit(0)
This terminates the JVM. So, It will directly stop the program. Finally aslo will not work

5)RestTemplate vs Feign client


6) Hibernate mapping
