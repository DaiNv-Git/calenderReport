package MyProject.webapp.modle.response.adminResponse;

import MyProject.webapp.exception.GeneralException;
import MyProject.webapp.modle.entity.WorkingScheduleEntity;
import MyProject.webapp.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubScheduleResponse {
    @JsonProperty(value = "id")
    private Long scheduleId;
    @JsonProperty(value = "startTime")
    private String startTime;
    @JsonProperty(value = "endTime")
    private String endTime;
    @JsonProperty(value = "shiftName")
    private String shiftName;
    @JsonProperty(value = "workTypeName")
    private String workTypeName;


    public SubScheduleResponse(WorkingScheduleEntity event) throws GeneralException {
        this.scheduleId = event.getId();
        this.startTime = DateUtils.parseLocalTimeToString(event.getStartTime());
        this.endTime = DateUtils.parseLocalTimeToString(event.getEndTime());
        this.workTypeName = event.getWorkType().getName();
        this.shiftName = event.getShift().getName();
    }
}
