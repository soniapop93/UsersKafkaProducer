package Producer;

import Requests.RequestsManager;
import Users.User;
import Users.generated.*;

public class Logic {
    RequestsManager requestsManager = new RequestsManager();
    public void producer() {

        // Get new user from API
        User newUser = requestsManager.getUser();

        // Set new user data to Employment
        Employment employment = Employment.newBuilder()
                .setTitle(newUser.getEmployment().getTitle())
                .setKeySkill(newUser.getEmployment().getKeySkill())
                .build();

        // Set new user data to Coordinates
        Coordinates coordinates = Coordinates.newBuilder()
                .setLatitude(newUser.getAddress().getCoordinates().getLatitude())
                .setLongitude(newUser.getAddress().getCoordinates().getLongitude())
                .build();

        // Set new user data to Address
        Address address = Address.newBuilder()
                .setCity(newUser.getAddress().getCity())
                .setStreetName(newUser.getAddress().getStreetName())
                .setStreetAddress(newUser.getAddress().getStreetAddress())
                .setZipCode(newUser.getAddress().getZipCode())
                .setState(newUser.getAddress().getState())
                .setCountry(newUser.getAddress().getCountry())
                .setCoordinates(coordinates)
                .build();

        // Set new user data to Credit Card
        CreditCard creditCard = CreditCard.newBuilder()
                .setCcNumber(newUser.getCreditCard().getCcNumber())
                .build();

        // Set new user data to Subscription
        Subscription subscription = Subscription.newBuilder()
                .setPlan(newUser.getSubscription().getPlan())
                .setStatus(newUser.getSubscription().getStatus())
                .setPaymentMethod(newUser.getSubscription().getPaymentMethod())
                .setTerm(newUser.getSubscription().getTerm())
                .build();

        // Set new user data to user Proto
        Users.generated.User userProto = Users.generated.User.newBuilder()
                .setId(newUser.getId())
                .setUid(newUser.getUid())
                .setPassword(newUser.getPassword())
                .setFirstName(newUser.getFirstName())
                .setLastName(newUser.getLastName())
                .setUsername(newUser.getUsername())
                .setEmail(newUser.getEmail())
                .setAvatar(newUser.getAvatar())
                .setGender(newUser.getGender())
                .setPhoneNumber(newUser.getPhoneNumber())
                .setSocialInsuranceNumber(newUser.getSocialInsuranceNumber())
                .setDateOfBirth(newUser.getDateOfBirth())
                .setEmployment(employment)
                .setAddress(address)
                .setCreditCard(creditCard)
                .setSubscription(subscription)
                .build();

        // todo: finish to serialize data

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
