// Generated by view binder compiler. Do not edit!
package com.example.a51thmobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.a51thmobile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SignupActivityBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final AppCompatEditText signEmail;

  @NonNull
  public final AppCompatEditText signName;

  @NonNull
  public final AppCompatEditText signPass;

  @NonNull
  public final AppCompatEditText signPassagain;

  @NonNull
  public final AppCompatEditText signPhone;

  @NonNull
  public final AppCompatEditText signPlace;

  @NonNull
  public final TextView signText;

  @NonNull
  public final Button singUpButton;

  @NonNull
  public final Toolbar toolbar;

  private SignupActivityBinding(@NonNull ScrollView rootView, @NonNull AppCompatEditText signEmail,
      @NonNull AppCompatEditText signName, @NonNull AppCompatEditText signPass,
      @NonNull AppCompatEditText signPassagain, @NonNull AppCompatEditText signPhone,
      @NonNull AppCompatEditText signPlace, @NonNull TextView signText,
      @NonNull Button singUpButton, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.signEmail = signEmail;
    this.signName = signName;
    this.signPass = signPass;
    this.signPassagain = signPassagain;
    this.signPhone = signPhone;
    this.signPlace = signPlace;
    this.signText = signText;
    this.singUpButton = singUpButton;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static SignupActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SignupActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.signup_activity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SignupActivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.sign_email;
      AppCompatEditText signEmail = ViewBindings.findChildViewById(rootView, id);
      if (signEmail == null) {
        break missingId;
      }

      id = R.id.sign_name;
      AppCompatEditText signName = ViewBindings.findChildViewById(rootView, id);
      if (signName == null) {
        break missingId;
      }

      id = R.id.sign_pass;
      AppCompatEditText signPass = ViewBindings.findChildViewById(rootView, id);
      if (signPass == null) {
        break missingId;
      }

      id = R.id.sign_passagain;
      AppCompatEditText signPassagain = ViewBindings.findChildViewById(rootView, id);
      if (signPassagain == null) {
        break missingId;
      }

      id = R.id.sign_phone;
      AppCompatEditText signPhone = ViewBindings.findChildViewById(rootView, id);
      if (signPhone == null) {
        break missingId;
      }

      id = R.id.sign_place;
      AppCompatEditText signPlace = ViewBindings.findChildViewById(rootView, id);
      if (signPlace == null) {
        break missingId;
      }

      id = R.id.sign_text;
      TextView signText = ViewBindings.findChildViewById(rootView, id);
      if (signText == null) {
        break missingId;
      }

      id = R.id.sing_up_button;
      Button singUpButton = ViewBindings.findChildViewById(rootView, id);
      if (singUpButton == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new SignupActivityBinding((ScrollView) rootView, signEmail, signName, signPass,
          signPassagain, signPhone, signPlace, signText, singUpButton, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}