package dmgateball.service.register;

import dmgateball.record.RegisterForm;
import dmgateball.repository.register.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final RegisterRepository registerRepository;

    public void register(RegisterForm form) {
        registerRepository.register(new RegisterEntity(form));
    }
}
