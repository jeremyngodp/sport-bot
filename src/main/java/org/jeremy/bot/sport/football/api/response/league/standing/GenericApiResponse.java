package org.jeremy.bot.sport.football.api.response.league.standing;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericApiResponse<T> {
    private String get;
    private Map<String, String> parameters;
    private List<String> errors;
    private int results;
    private Map<String, Integer> paging;

    private List<T> response;
}
