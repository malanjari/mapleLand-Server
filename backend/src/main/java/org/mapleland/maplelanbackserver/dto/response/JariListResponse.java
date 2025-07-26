package org.mapleland.maplelanbackserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapleland.maplelanbackserver.dto.Map.JariResponse;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JariListResponse {
    private List<JariResponse> jariList;
    private int currentPage;
    private int totalPage;
    private long totalElements;
    private int pageSize;

    public static JariListResponse from(Page<JariResponse> page) {
        return new JariListResponse(
                page.getContent(),
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize()
        );
    }
}
