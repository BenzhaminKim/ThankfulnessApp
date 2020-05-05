package com.thankfulness.thankfulness.viewModel;

import com.thankfulness.thankfulness.model.Thankfulness;
import com.thankfulness.thankfulness.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ThankfulnessToken {
    private Token token;
    private Thankfulness thankfulness;
}
