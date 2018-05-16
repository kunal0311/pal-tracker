package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = timeEntries.size() + 1L;
        TimeEntry timeEntryNew = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.put(id, timeEntryNew);
        return timeEntryNew;
    }

    @Override
    public TimeEntry find(Long id) {
        TimeEntry timeEntry = timeEntries.get(id);
        return timeEntry;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry timeEntryUpdate = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.replace(id, timeEntryUpdate);
        return timeEntryUpdate;
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }

    @Override
    public ArrayList list() {
        return new ArrayList<>(timeEntries.values());
    }
}
