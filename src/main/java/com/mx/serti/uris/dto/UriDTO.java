package com.mx.serti.uris.dto;

import com.mx.serti.uris.entity.Uri;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.mx.serti.util.documentation.UriDocumentation.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(name = URI,description = URI_DTO)
public class UriDTO {

    @Schema(name = URI_ID, example = URI_ID_EXAMPLE_VALUE, description = URI_ID_DESCRIPTION)
    private int uriId;

    @Schema(name = URI_URL, example = URI_URL_EXAMPLE_VALUE, description = URI_URL_DESCRIPTION)
    private String uriUrl;

    @Schema(name = URI_DESCRIPTION, example = URI_DESCRIPTION_EXAMPLE_VALUE, description = URI_DESCRIPTION_DESCRIPTION)
    private String uriDescription;

    public UriDTO(Uri request) {
        this.setUriId(request.getUriId());
        this.setUriUrl(request.getUriUrl());
        this.setUriDescription(request.getUriDescription());
    }

}
