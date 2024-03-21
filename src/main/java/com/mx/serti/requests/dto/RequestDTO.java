package com.mx.serti.requests.dto;

import com.mx.serti.requests.entity.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.mx.serti.util.documentation.RequestDocumentation.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(name = REQUEST,description = REQUEST_DTO)
public class RequestDTO {

    @Schema(name = REQ_ID, example = REQ_ID_EXAMPLE_VALUE, description = REQ_ID_DESCRIPTION)
    private int reqId;

    @Schema(name = REQ_URL, example = REQ_URL_EXAMPLE_VALUE, description = REQ_URL_DESCRIPTION)
    private String reqUrl;

    @Schema(name = REQ_DESCRIPTION, example = REQ_DESCRIPTION_EXAMPLE_VALUE, description = REQ_DESCRIPTION_DESCRIPTION)
    private String reqDescription;

    public RequestDTO(Request request) {
        this.setReqId(request.getReqId());
        this.setReqUrl(request.getReqUrl());
        this.setReqDescription(request.getReqDescription());
    }

}
