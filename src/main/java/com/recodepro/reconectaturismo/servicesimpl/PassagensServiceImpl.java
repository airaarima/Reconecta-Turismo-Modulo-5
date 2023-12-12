package com.recodepro.reconectaturismo.servicesimpl;

import com.recodepro.reconectaturismo.exception.PassagemNotFoundException;
import com.recodepro.reconectaturismo.exception.UsuarioNotFoundException;
import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.repository.PassagensRepository;
import com.recodepro.reconectaturismo.services.PassagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagensServiceImpl implements PassagensService {
    @Autowired
    private PassagensRepository pr;

    @Override
    public List<Object[]> getAllPassagens() {
        List<Object[]> passagens = pr.getAllPassagens();
        return passagens;
    }

    @Override
    public Passagens deleteById(Long id) {
        Passagens passagem = pr.findById(id).orElseThrow(() -> new PassagemNotFoundException());
        pr.deleteById(passagem.getId());
        return passagem;
    }


}
