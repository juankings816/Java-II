package co.com.ps.C23A.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Products {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "product_id")
    private Long productId;

    @Column(columnDefinition = "product_name")
    private String productName;

    @Column(columnDefinition = "description")
    private String description;

    @Column(columnDefinition = "price", nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "stock", nullable = false)
    private Integer stock;

    @Column(columnDefinition = "created_at")
    private LocalTime createdAt;

    @Column(columnDefinition = "updated_at")
    private LocalTime updatedAt;

    @ManyToOne
    @JoinColumn (name = "category_id", nullable = false)
    private Category category;
}
