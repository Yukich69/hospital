package com.solvd.hospital.info;

import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.DiseaseType;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.people.Patient;
import com.solvd.hospital.service.Consultation;
import com.solvd.hospital.service.Payment;
import com.solvd.hospital.service.Referral;
import com.solvd.hospital.structure.Administration;
import com.solvd.hospital.structure.Department;
import com.solvd.hospital.structure.Hospital;
import com.solvd.hospital.structure.Office;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfoSetup {

    private static final Logger log = LogManager.getLogger(InfoSetup.class);
    private Random random = new Random();

    public void info(File file) {
        String text;
        try {
            text = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String word = "care";
            log.info("Word: " + word + ", Num: " + StringUtils.countMatches(text, word));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void surf(String str) {
        log.info("===============================================================" +
                "===========================================");
        log.info("\t\t" + str);
        log.info("===============================================================" +
                "===========================================");
    }

    public static void addAnswers(String... answers) {
        String str = "";
        String space = "";
        String edge = "";
        for (int i = 0; i < answers.length; i++) {
            if(i != 0 && i != answers.length) str += ",  ";
            str += answers[i];
        }
        for (int i = 0; i < str.length(); i++) {
            edge += "=";
            space += " ";
        }
        log.info(edge);
        log.info(space);
        log.info(str);
        log.info(space);
        log.info(edge);
    }

    private Hospital createHospital(){
        Hospital hospital = new Hospital();
        hospital.setName("HopeHospital");
        hospital.setDepartmentList(addDepartments());
        hospital.setAdministration(addAdministration());
        return hospital;
    }

    private Administration addAdministration() {
        Administration administration = new Administration();
        return administration;
    }

    private ArrayList<Department> addDepartments() {
        ArrayList<Doctor> surgDoctors = addSurgeryDoctors();
        ArrayList<Doctor> cardioDoctors = addCardioDoctors();
        ArrayList<Nurse> surgNurse = addSurgeryNurses();
        ArrayList<Nurse> cardioNurse = addCardioNurses();
        ArrayList<Department> departments = Stream.of(new Department("Surgery", surgDoctors, surgNurse),
                        new Department("Cardiology", cardioDoctors, cardioNurse))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return departments;
    }

    private ArrayList<Doctor> addCardioDoctors() {

        Doctor doc1 = new Doctor(new Office(3), "Ben");
        doc1.setPatientList(addPatients());

        Doctor doc2 = new Doctor(new Office(4), "Fill");
        doc2.setPatientList(addPatients());

        ArrayList<Doctor> cardioDocs = Stream.of(doc1, doc2)
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return cardioDocs;
    }

    private ArrayList<Nurse> addCardioNurses() {
        ArrayList<Nurse> cardioNur = Stream.of(new Nurse( "Hellen", 32),
                        new Nurse("Jane", 30))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return cardioNur;
    }

    private ArrayList<Nurse> addSurgeryNurses() {
        ArrayList<Nurse> surgeryNur = Stream.of(new Nurse("Emma", 37),
                        new Nurse("Lis", 35))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return surgeryNur;
    }

    private ArrayList<Patient>  addPatients(){
        HealthCard card1 = new HealthCard();
        HealthCard card2 = new HealthCard();

        ArrayList<Patient> patients = Stream.of(new Patient("David", 23, "male", card1),
                        new Patient("fred", 43, "male", card2))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return patients;
    }
    private ArrayList<Doctor> addSurgeryDoctors() {

        Doctor doc1 = new Doctor(new Office(1), "Jon");
        doc1.setPatientList(addPatients());

        Doctor doc2 = new Doctor(new Office(2), "Jack");
        doc2.setPatientList(addPatients());

        ArrayList<Doctor> surgeryDocs = Stream.of(doc1, doc2)
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return surgeryDocs;
    }

    public void start(){

        Hospital hospital = createHospital();
        surf(hospital.getName());
        Payment pay = new Payment();

        Scanner scanner = new Scanner(System.in);
        String str = null;

        boolean isTumor= false;
        boolean isCardio = false;
        boolean isConsultation = false;
        boolean isChoosed = false;

        while (!isChoosed ) {
            surf("Hello! What's your problem?");
            addAnswers("heartache(enter 1)", "tumor(enter 2)", "ask for consultation(enter 3)");
            str = scanner.nextLine().replaceAll("\\s+", "");
            switch (str) {
                case "1":
                    isCardio = true;
                    isChoosed  = true;
                    break;
                case "2":
                    isTumor = true;
                    isChoosed  = true;
                    break;
                case "3":
                    isConsultation = true;
                    isChoosed  = true;
                    break;
                default:
                    surf("Something went wrong, try again");
                    break;
            }
        }
        if(isCardio){
            isChoosed = false;
            Referral referral = createCardioRefferal();
            surf("You are the patient of " + referral.getDoctor().getName());
            while (!isChoosed ) {
                surf("You can cure the disease");
                addAnswers("yes", "no");
                str = scanner.nextLine().replaceAll("\\s+", "");
                switch (str) {
                    case "yes":
                        try {
                            Disease dis = referral.getPatient().getCard().getDiseaseList().stream().findFirst()
                                    .filter(x -> x.getDiseaseType().equals(DiseaseType.CARDIO)).get();
                            surf(dis.getDisease() + " is cured");
                            referral.getPatient().getCard().getDiseaseList().remove(dis);
                            referral.setPrice(150);
                        }catch (NoSuchElementException e){
                            surf("Sorry " + referral.getDoctor().getName() + " can't cure surgery problem");
                        }
                        isChoosed  = true;
                        break;
                    case "no":
                        surf("Do this later");
                        isChoosed  = true;
                        break;
                    default:
                        surf("Something went wrong, try again");
                        break;
                }
            }
            pay.increasePayment(referral.getPrice());
        }
        if(isTumor){
            isChoosed = false;
            Referral referral = createSurgeonRefferal();
            surf("You are the patient of " + referral.getDoctor().getName());
            while (!isChoosed ) {
                surf("You can cure the disease");
                addAnswers("yes", "no");
                str = scanner.nextLine().replaceAll("\\s+", "");
                switch (str) {
                    case "yes":
                        try {
                            Disease dis = referral.getPatient().getCard().getDiseaseList().stream().findFirst()
                                    .filter(x -> x.getDiseaseType().equals(DiseaseType.SURGERY)).get();
                            surf(dis.getDisease() + " is cured");
                            referral.getPatient().getCard().getDiseaseList().remove(dis);
                            referral.setPrice(200);
                        }catch (NoSuchElementException e){
                            surf("Sorry " + referral.getDoctor().getName() + " can't cure cardio problem");
                        }
                        isChoosed  = true;
                        break;
                    case "no":
                        surf("Do this later");
                        isChoosed  = true;
                        break;
                    default:
                        surf("Something went wrong, try again");
                        break;
                }
            }
            pay.increasePayment(referral.getPrice());
        }
        if(isConsultation){
            isChoosed = false;
            Consultation consultation = createConsult();
            surf( consultation.getNurse().getName() + " says that you need more vitamins, " +
                    "before consultation at " + consultation.getDate());
            while (!isChoosed ) {
                surf("You will be there at " + consultation.getDate());
                addAnswers("yes", "no");
                str = scanner.nextLine().replaceAll("\\s+", "");
                switch (str) {
                    case "yes":
                        surf("You are almost healthy");
                        Doctor doc = Nurse.hired.hire(consultation.getNurse());
                        doc.setOffice(new Office(7));
                        surf(doc.getName() + " is a doctor now, you can find her at office " + doc.getOffice().getOffice());
                        consultation.setPrice(50);
                        isChoosed  = true;
                        break;
                    case "no":
                        surf("Do this later");
                        isChoosed  = true;
                        break;
                    default:
                        surf("Something went wrong, try again");
                        break;
                }
            }
            pay.increasePayment(consultation.getPrice());
        }
        surf("Payment for service is: " + pay.getPrice());
        Nurse nurse = addCardioNurses().get(1);
        tellSecret(nurse);
    }

    private Referral createSurgeonRefferal() {
        Doctor doctor = addSurgeryDoctors().get(random.nextInt(2));
        Patient patient = doctor.addPatient();
        Referral referral = new Referral();
        referral.setDoctor(doctor);
        referral.setPatient(patient);
        referral.setPrice(150);
        return referral;
    }

    private Referral createCardioRefferal() {
        Doctor doctor = addCardioDoctors().get(random.nextInt(2));
        Patient patient = doctor.addPatient();
        Referral referral = new Referral();
        referral.setDoctor(doctor);
        referral.setPatient(patient);
        return referral;
    }

    private Consultation createConsult() {
        Nurse nurse = addCardioNurses().get(random.nextInt(2));
        Calendar calendar = Calendar.getInstance();
        Consultation consult = new Consultation();
        consult.setDate(calendar.getTime().toString());
        consult.setNurse(nurse);
        return consult;
    }

    private void tellSecret(Nurse nurse){

        try {
            Field field = nurse.getClass().getDeclaredField("secret");
            field.setAccessible(true);
            surf(nurse.getName() + (String) field.get(nurse));

            Method method = nurse.getClass().getDeclaredMethod("secretReveal", String.class);
            method.setAccessible(true);
            method.invoke(nurse, "Eric");
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
