package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
