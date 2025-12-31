Round 1:

@Query("select e.name from Employee e where e.id= @id",)
public Optional<> getEMployeeName(long id){

}



@RestController
@RequestMapping("")
public class EmployeeController{

    @RequestMapping("employee/api/v1/")
    public ResponseEntity<> saveEmployee(@)


}
@Bean

Class createBean(){
    //
}


@Bean
Class createBean(){
    //
}

Child

Child



@Autowired
ParentInter inter



select * from Employee where name like "s%" order by salary asc


List<Integer> list = new ArrayList<>();

input: list = {10,16, 13, 12, 14, 11} and target total=24
output: 2 
below are the combinations
(10,14), (13,11)
list.stream().forEach(System.out::println);

public 


private void findCombination(int[] input,  ArrayList<ArrayList<Integer>> output, ArrayList<Integer> cur, int target, int i){
//10,16, 13, 12, 14, 11
    if(target< 0 || i == input.length)
        return;

    if(target == 0){
        output.add(new ArrayList<>(cur))
        return;
    }

    cur.add(input[i]);
    findCombination(input, output, cur, target - input[i], i+1);
    cur.remove(cur.size() - 1);
    findCombination(input, output, cur, target, i+1);
}


@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)

nativeQuery = true -> database dependent
nativeQuery = false -> jpql - database dpenedent (SELECT u FROM users WHERE email = :email) syntax changes


Aot in angular



Round 2:
Given an offset n, 
write an encode function that encodes an input string by shifting all Latin simple letters (a-z and A-Z) by the offset n. 
Other characters remain untouched. Example: given n = 2, “ab Y” becomes “cd A”. Also write a decode function.


public String encode(String s, int n){
    char[] ch = s.toCharArray();//ab Y
    StringBuilder s = new StringBuilder();
    for(int i=0; i<ch.length; i++){
        char c = ch[i];//b
        if((c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z')){
            if('Z' - c+n < 0){
                int exc = c+n - 'Z';
                c = 
            }
            c += n; //
        }
        s.append(c);//cd 
    }
    return s.toString();
}


public String decode(String s, int n){
    char[] ch = s.toCharArray();
    StringBuilder s = new StringBuilder();
    for(int i=0; i<ch.length; i++){
        char c = ch[i];
        if(c.isAlphabetic()){
            c += n;
        }
        s.append(c);
    }
    return s.toString();
}




list = [1,2,3,4,5]


int[] reverse(int[] list){
    int[] rev = new int[list.length];
    recursive(list, rev, list.length-1);
    return rev;
}


void recursive(int[] list, int[] rev, int i){ //5
    if(i == 0)
        return;

    recursive(list, rev, i-1);
    rev[list.length - 1 - i]= list[i]; 
}


//5
//4
//3
//2
//1

//5
//4
//3
//2
//1


Ui - react
Bff - Fastify Node library

Backend end - Side car (check autication)

rest endpoint
SpringBoot
controller
service
repos

config
db
security

deployment.yaml
    replicas
        min, max
ingress
jenkins file(steps)

docker file

docker file
Kubernetes

secret manager
config manager

github
webhook - commit, pr -> jenkins


rolling update deployment



apply flow

BE ->

start
reposne nased on job

{
    id:
    type:
    destination:
}

next
based on filled data
{
    id:
    type:
    destination:
}

FE
start - jobId

[{
    id:
    type: input_text
    destination: return
},
{

}
]