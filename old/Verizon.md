HTML5 advantages
Direct Audio, Video files
Inbuilt database

Https
http+secured - all communication will encrypted, so its secured
Using Http - all communications are in plain text(easily hacked) so we use https

Digital certificate :
In the beginning, you request a certificate from a certificate authority(CA) by providing CSR (consist of domain details and public key of the server).
Then the CA will issue a digital certificate with the following steps:
CSR is signed with hashing algorithms i.e., SHA256/md5 generates hash(CSR)
Digital certificate = CSR + privateKey

HandShaking Process:
Client loads the server URL
The server sends a certificate(CSR + Private Key) to the user agent while making a TLS connection.
Then the user agent(browser) looks at the certificate checks whether the certificate is from trusted CA's.
If it is from trusted CA's, then the user agent parses the certificate, where we will get CSR and private key.
Now browser gets trusted CA certificate's public key over internet
Encrypted(hash(CSR)) is decrypted using the public key of CA. from this, we will get hash(CSR).
If its not decryped it shows clients public key and servers private key is not of pair. So authentication failed




Change Http to Htpps protocol in Server(eg:Tomcat)
Create KeyStore.
Install CA issued certificate in that keystore (eg : keytool -import -alias root -keystore /etc/pki/keystore -trustcacerts -file root.crt).
Mention this keystore path in server config and alter the values related to https.
Restart the server.

SqlInjection
Batch type
User id: |105; DROP TABLE Suppliers|
Lets consider this as UI field. So generates query as 
SELECT * FROM Users WHERE UserId = 105; DROP TABLE Suppliers;
or Type
User id: |'' or ''==''|
so query looks like
SELECT * FROM Users WHERE UserId = '' or '' == ''  --> which returns enteir table values.

XXS - Cross-site scripting
Scripting the URL may be a security threat 
Eg: Our URL is localhost:8080/home?name=eswar
Cross-site Scripting can be is localhost:8080/home?name=<script>alert(eswar)<script> which may lead to alert the value
To avoid this we should sanitize it and should use.
