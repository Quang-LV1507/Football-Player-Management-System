/*
 * Parent class for Contract, Salary, MatchRecord and TrainingSession.
 * These classes are all records managed by the football club.
 */
public abstract class ClubRecord extends ClubEntity {
    public ClubRecord() {
        super();
    }

    public ClubRecord(String recordId) {
        super(recordId);
    }

    public String getRecordId() {
        return getId();
    }
}
