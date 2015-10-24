# Match Manager

This simple project was developed for an universitary exam on BPMN2.0.
The context is a website for the football match bookings. The system allows of create new user log-in in the system create a new team for the match and 
booking a new match. The particularity of the system is that during the booking only one of the two team is built and the other team is built 
for action of other user that join in the team challenger before the day of the match.

# Technologies

<ol>
    <li>Spring</li>
    <li>Spring MVC</li>
    <li>Spring Batch</li>

    <li>Apache Tiles</li>
    <li>Apache CXF</li>

    <li>Alfresco Activiti</li>

    <li>Maven</li>
</ol>

# Running instructions
The system was developed with two build profile: embedded and default. With the embedded profile the system will use an h2 embedded database prepolated by 
a batch written in spring batch. With the default profile the system will required a mysql db.
For configure the profile will sufficient set spring.profiles.active paramiter with <b>-Dspring.profiles.active=profile</b> in the startup script of tomcat or 
anyother application server in which yuo want deployed the system. 