Wenger & Watson

## spring security

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

public class JwtUtil {
   
    public static String generateToken(String username, String role) {
      ...
    }

    public static Jws<Claims> validateToken(String token) {
       ...
    }
}

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;

    public JwtFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            try {
                var claims = JwtUtil.validateToken(jwt).getBody();
                String username = claims.getSubject();
                var userDetails = userDetailsService.loadUserByUsername(username);
                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}

steps:
filter creation
    add validation in doFilter()
security Configuration
    configure securityFilterChain
    configure filter in securityFilterChain


## how jvm manages space

Heap
    Young Generation
        Eden space: new objects are created here.
        Survivor spaces: objects copied here if they survive GC.
    Old Generation : Long-lived objects promoted here.

Stack (per thread)
    Each thread has its own stack
        Local(static) variables
        References to objects

Method Area
    Stores class metadata, method code, static variables, runtime constants.

PC Register (per thread)
    current instruction address for the thread(execution pointer for one thread.)

Native Method Stack
    native (JNI) calls - Java code to call code written in other languages


How memory is cleared

Heap
    GC will clear Heap.
        Triggered when Eden(having new object) is full. Minor GC clears Eden space. moves survived objects to Survivor space with a counter
        Eden will be cleared again and again once for each time on getting full. moves survived objects to Survivor. If that object already present, it increase the counter
        If counter is 15, that object is moved to old gen
        Once old gen is full, Major GC will be cleared like old gen

Stack
    Cleared automatically when method ends.

Method Area(before java 8) / Metaspace(after java 8)
    Class metadata cleared when classloader is GC’d.

PC Register
    Cleared when thread ends. No GC.

Native Method Stack
    Cleared when native call returns


How object is dereferenced
once method ends(where object is created). The stack frame is destroyed . So, it gets derefferenced.



why bst in hashmap after java
faster lookup time log n


why still 8 its linkedlist
small numbers of collisions, a Linked List is actually faster than a tree.
no balancing, no extra pointers, less overhead.

linkedlist
static class Node<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}

Tree
static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
    TreeNode<K,V> parent;
    TreeNode<K,V> left;
    TreeNode<K,V> right;
    TreeNode<K,V> prev;
    boolean red;
}

we can see overhead here


Why Hashcode()?
It is mostly used in collection for fast retrevial of bucket


Why collection uses object?
Before java 5.. there is no generic only Object List<Object>
Now also underhood when u add a object of type Employee.. it boxes it to Object

everything stored in collection is reference(not value).
By storing references, a Collection can treat all objects uniformly, without caring about their actual size or internal structure.

This cannot be possible in primitive type
