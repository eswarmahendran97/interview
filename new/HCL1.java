HCL

Complex query
No Object-Relational Mapping Overhead in JDBC
No Entity Manager


JOIN in JPA
@OneToMany, @ManyToOne, @OneToOne, and @ManyToMany


Hibernate over JPA


sql
select name from StudClass where mark = (select max(mark) from StudClass where mark < (select max(mark) from StudClass))


// tea, eat


List<String> list

boolean[] vis = new boolean[list.size()];
List<String, Set<String> res = new ArrayList<>();


for(int i=0; i<list.size(); i++){
    if(vis[i] == true){
        continue;
    }
    vis[i] = true;
    Set<String> set = new HashSet<>();
    Map<Charachter, Integer> map = new HashMap<>();
    String a = list.get(i);
    for(int i = 0; i<a.length(); i++){
        map.put(map.getOrDefault(a.charAt(i), 0)+1);
    }
    for(int j=i+1; i<list.size(); i++){
        if(!vis[j] && checkAnagram(map, list.get(j))){
            vis[j] = true;
            set.add(list.get(j));
        }
    }
    if(set.size() != 0){
        set.add(list.get(i));
        res.add(list.get(i), set);
    }

}


boolean checkAnagram(Map<Charachter, Integer> map, String b){
    for(int i = 0; i<b.length(); i++){
        if(map.contains(b.charAt(i))){
            if(map.get(b.charAt(i)) == 1){
                map.remove(b.charAt(i));
            } else{
                map.put(map.get(b.charAt(i)) - 1);
            }
        }
    }
    return map.size() == 0;
}