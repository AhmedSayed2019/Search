package roomDB;



public class SearchModel {
    private String nationalID , name ,caseNumber ,criminalRecordNumber ,year ,address ,criminalType,courtHearingDate, judge;

    public SearchModel(String nationalID, String name, String caseNumber, String criminalRecordNumber, String year, String address, String criminalType, String courtHearingDate ,String judge) {
        this.nationalID = nationalID;
        this.name = name;
        this.caseNumber = caseNumber;
        this.criminalRecordNumber = criminalRecordNumber;
        this.year = year;
        this.address = address;
        this.criminalType = criminalType;
        this.courtHearingDate = courtHearingDate;
        this.judge = judge;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getName() {
        return name;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public String getCriminalRecordNumber() {
        return criminalRecordNumber;
    }

    public String getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public String getCriminalType() {
        return criminalType;
    }

    public String getCourtHearingDate() {
        return courtHearingDate;
    }

    public String getJudge() {
        return judge;
    }
}
