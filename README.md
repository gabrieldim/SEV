# SEV - Secure E-Voting

## The system is using mutual X.509 authentication

The client verfies the server according to it's certificate, that certificate is issued by a trusted certificate authority.

By using X.509 in Spring Security the server verifies the identity of the client (voter) while the client is connecting.

The system uses it's own Root CA (Certificate Authority) and it uses it to sign server-side and client-side certificates. Using the OpenSSL library we generated our own Root CA and used it to sign both the server and the client certificates.

---

## The project is structered as two seperate applications

- The first application is the <strong>"cert-email-sender"</strong> located in the folder with same name, this is the application that the voters use to obtain their X.509 certificate so that they authenticate in order to vote.

- The second application is <strong> "sev" </strong> located in the folder with the same name, this is where the actual voting happens. In order to be able to access anything on this application you first need to obtain your certificate via the "cert-email-sender".

These are both completely different systems and they both serve their specific task. 

---

## Use case flow

1. The voter receives a generated CODE by post to his home address. This CODE must be used on the <strong> "Request a Certificate Form" </strong> in order to obtain the Certificate via email. The use of the CODE is the only valid way for the user to obtain a Certificate.

2. The user goes on the "Request a Certificate Form" page. On this page the user enters the CODE, the first name, the last name and the e-mail where the user wants to receive the <strong>X.509 Client Certificate </strong> to be able to continue with the voting process.

3. The user should check their e-mail inbox, there they should have received their certificate and the password for the certificate. Then the user should import the certificate in the web browser. (The instructions are below in the instructions section).
 
4. After importing the certificate the user can vote. In order to vote the user goes to the voting page on the <strong>"sev"</strong>. When the user tries to access the voting page a prompt will pop-up asking for a certificate. The user should choose the previosly imported certificate and click <strong>OK</strong>.

5. Then the user will be presented with the voting interface, this interface is available only if the user presents the client certificate and there is no other way to get to the interface and vote. 

6. When the user votes, only the ID for the selected candidate is sent and after the user has voted there is no way to whom the vote has been given, it only increments the vote count of the selected candidate.

7. After the successfull voting the user will be presented with the current results of the votes.

8. After the voting is completed the user can no longer vote again and an appropriate message will be shown.

---
### Instructions

Install a .p12 certificate in Firefox:

1. Type <strong>about:preferences</strong> in the address bar (or open the top menu bar and choose <strong>Preferences</strong>).

2. Search for certificates and click <strong>View Certificates -> Your Certificates </strong>

3. Click on <strong>Import</strong>

4. Locate the downloaded Certificate that got sent to your email and click <strong>OK</strong>

5. Input the password that you got sent to your email in order to import the certificate and click <strong>OK</strong>





