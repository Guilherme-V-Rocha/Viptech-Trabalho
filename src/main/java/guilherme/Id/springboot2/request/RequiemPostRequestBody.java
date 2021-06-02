package guilherme.Id.springboot2.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RequiemPostRequestBody {
    @NotEmpty(message = "The requiem cannot be empty")
    private String name;
}
